package com.example.svsport

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.SideEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.rememberNavController
import com.example.svsport.ui.app.Navigation.AppNavHost
import com.example.svsport.ui.app.Navigation.AppPreview
import com.example.svsport.ui.app.screens.StepTracker.StepCounterManager
import com.example.svsport.ui.app.screens.StepTracker.createNotificationChannel
import com.example.svsport.ui.theme.SvSportTheme
import com.google.accompanist.permissions.ExperimentalPermissionsApi
import com.google.accompanist.permissions.isGranted
import com.google.accompanist.permissions.rememberPermissionState
import com.google.accompanist.permissions.shouldShowRationale
import com.google.accompanist.systemuicontroller.rememberSystemUiController

class MainActivity : ComponentActivity() {

    private lateinit var stepCounterManager: StepCounterManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        createNotificationChannel(this)

        stepCounterManager = StepCounterManager(this)

        setContent {
            SvSportTheme {

                SetBarColor(color = Color.White)

                val navController = rememberNavController()
                AppNavHost(navController = navController)
            }
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        stepCounterManager.unregister()
    }
}

@Composable
private fun SetBarColor(color: Color) {

    val systemUiController = rememberSystemUiController()

    SideEffect {

        systemUiController.setSystemBarsColor(

            color = color

        )

    }

}

