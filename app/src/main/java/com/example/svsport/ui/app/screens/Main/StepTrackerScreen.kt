package com.example.svsport.ui.app.screens.Main

import android.app.ActivityManager
import android.content.Context
import android.content.Intent
import android.os.Build
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.core.content.ContextCompat
import com.example.svsport.ui.app.screens.StepTracker.StepCounterManager
import com.example.svsport.ui.app.screens.StepTracker.StepCounterPreferences
import com.example.svsport.ui.app.screens.StepTracker.StepCounterService
import com.google.accompanist.permissions.ExperimentalPermissionsApi
import com.google.accompanist.permissions.isGranted
import com.google.accompanist.permissions.rememberPermissionState
import com.google.accompanist.permissions.shouldShowRationale
import kotlinx.coroutines.delay

@OptIn(ExperimentalPermissionsApi::class)
@Composable
fun StepTrackerScreen(onNavigateBack: () -> Unit) {

    val context = LocalContext.current
    val stepCount = remember { mutableStateOf(StepCounterPreferences.getStepCount(context)) }

    val permission = rememberPermissionState(permission = android.Manifest.permission.ACTIVITY_RECOGNITION)

    // Запрашиваем разрешение, если требуется
    LaunchedEffect(Unit) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.Q && !permission.status.isGranted) {
            permission.launchPermissionRequest()
        }
    }

    // Обновляем шаги каждые 1 секунду
    LaunchedEffect(Unit) {
        while (true) {
            stepCount.value = StepCounterPreferences.getStepCount(context)
            delay(1000)
        }
    }

    // Запуск и остановка службы
    DisposableEffect(permission.status.isGranted) {
        if (permission.status.isGranted) {
            val serviceIntent = Intent(context, StepCounterService::class.java)
            ContextCompat.startForegroundService(context, serviceIntent)

            onDispose {
                if (isServiceRunning(context, StepCounterService::class.java)) {
                    context.stopService(serviceIntent)
                }
            }
        } else {
            onDispose { /* Ничего не делаем */ }
        }
    }

    Surface(
        modifier = Modifier.fillMaxSize(),
        color = MaterialTheme.colorScheme.background
    ) {
        Column(
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            when {
                permission.status.isGranted -> {
                    Text(text = "Steps: ${stepCount.value}")
                }
                permission.status.shouldShowRationale -> {
                    Button(onClick = { permission.launchPermissionRequest() }) {
                        Text(text = "Grant Permission")
                    }
                }
                else -> {
                    Text(text = "Permission required to track steps.")
                }
            }

            Spacer(modifier = Modifier.height(16.dp))

            Button(onClick = onNavigateBack) {
                Text("Back to Auth Main")
            }
        }
    }
}

fun isServiceRunning(context: Context, serviceClass: Class<*>): Boolean {
    val manager = context.getSystemService(Context.ACTIVITY_SERVICE) as ActivityManager
    return manager.getRunningServices(Int.MAX_VALUE).any {
        it.service.className == serviceClass.name
    }
}