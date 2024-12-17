package com.example.svsport.ui.app.screens.Main

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
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import com.example.svsport.ui.app.screens.StepTracker.StepCounterManager
import com.google.accompanist.permissions.ExperimentalPermissionsApi
import com.google.accompanist.permissions.isGranted
import com.google.accompanist.permissions.rememberPermissionState
import com.google.accompanist.permissions.shouldShowRationale

@OptIn(ExperimentalPermissionsApi::class)
@Composable
fun StepTrackerScreen(onNavigateBack: () -> Unit) {

    val context = LocalContext.current
    val stepCounterManager = remember { StepCounterManager(context) }
    val stepCount = stepCounterManager.stepCount.collectAsState(initial = 0)

    DisposableEffect(Unit) {
        onDispose {

            stepCounterManager.unregister()

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
            val permission = rememberPermissionState(permission = android.Manifest.permission.ACTIVITY_RECOGNITION)

            LaunchedEffect(Unit) {
                permission.launchPermissionRequest()
            }

            when {
                permission.status.isGranted -> {
                    Text(text = stepCount.value.toString())
                }
                permission.status.shouldShowRationale -> {
                    Button(onClick = { permission.launchPermissionRequest() }) {
                        Text(text = "Give Permission")
                    }
                }
            }

            Spacer(modifier = Modifier.height(16.dp))

            Button(onClick = onNavigateBack) {

                Text("Back to Auth Main")

            }
        }
    }
}