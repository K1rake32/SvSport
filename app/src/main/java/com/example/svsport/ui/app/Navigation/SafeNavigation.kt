package com.example.svsport.ui.app.Navigation

import android.util.Log
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.ui.Alignment
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.zIndex
import androidx.navigation.compose.NavHost
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.svsport.ui.app.BottomNavigation.BottomNavigation
import com.example.svsport.ui.app.screens.Auth.AuthMainScreen
import com.example.svsport.ui.app.screens.Auth.FillOutAuth
import com.example.svsport.ui.app.screens.Main.MainScreen
import com.example.svsport.ui.app.screens.Main.NotificationScreen
import com.example.svsport.ui.app.screens.Main.ProfileScreen
import com.example.svsport.ui.app.screens.Main.StepTrackerScreen
import com.example.svsport.ui.app.screens.OnBoarding.OnBoardingScreenOne
import com.example.svsport.ui.app.screens.OnBoarding.OnBoardingScreenThree
import com.example.svsport.ui.app.screens.OnBoarding.OnBoardingScreenTwo
import com.example.svsport.ui.app.screens.OnBoarding.WelcomeScreen

sealed class Screen(val route: String) {
    object Welcome: Screen("welcome")
    object OnBoardingOne: Screen("onboarding_one")
    object OnBoardingTwo: Screen("onboarding_two")
    object OnBoardingThree: Screen("onboarding_three")
    object AuthMain : Screen("auth_main")
    object FillOutAuth: Screen("fill_out")
    object MainScreen: Screen("main_screen/{weight}/{height}") {

        fun createRoute(weight: String, height: String) = "main_screen/$weight/$height"

    }

    object NotificationScreen: Screen("notification_screen")
    object ProfileScreen: Screen("profile_screen/{weight}/{height}") {

        fun createRoute(weight: String, height: String) = "profile_screen/$weight/$height"

    }
    object StepTracker : Screen("step_tracker")
}

@Composable
fun AppNavHost(navController: NavHostController) {

    Scaffold(

        bottomBar = {

            if (navController.currentBackStackEntryAsState().value?.destination?.route in listOf(Screen.MainScreen.route, Screen.ProfileScreen.route)) {

                val weight = navController.currentBackStackEntry?.arguments?.getString("weight") ?: ""
                val height = navController.currentBackStackEntry?.arguments?.getString("height") ?: ""
                
                Box(modifier = Modifier
                    .zIndex(1f)

                ) {

                    BottomNavigation(navController = navController, weight = weight, height = height)

                }
            }

        }

    ) { innerPadding ->

        NavHost(
            navController = navController,
            startDestination = Screen.Welcome.route,
            modifier = Modifier.padding(innerPadding)
        ) {

            composable(Screen.Welcome.route) {
                WelcomeScreen(
                    onNavigateToOneBoardingOne = {
                        navController.navigate(Screen.OnBoardingOne.route)
                    }
                )
            }

            composable(Screen.OnBoardingOne.route) {
                OnBoardingScreenOne(
                    onNavigateToOneBoardingTwo = {
                        navController.navigate(Screen.OnBoardingTwo.route)
                    }
                )
            }

            composable(Screen.OnBoardingTwo.route) {
                OnBoardingScreenTwo(
                    onNavigateToOneBoardingThree = {
                        navController.navigate(Screen.OnBoardingThree.route)
                    }
                )
            }

            composable(Screen.OnBoardingThree.route) {
                OnBoardingScreenThree(
                    onNavigateToAuthMain = {
                        navController.navigate(Screen.AuthMain.route)
                    }
                )
            }

            composable(Screen.AuthMain.route) {
                AuthMainScreen(
                    onNavigateToFillOut = {
                        navController.navigate(Screen.FillOutAuth.route)
                    }
                )
            }

            composable(Screen.FillOutAuth.route) {
                FillOutAuth(
                    onNavigateToMainScreen = { weight, height ->
                        navController.navigate(Screen.MainScreen.createRoute(weight, height))
                    },

                    onNavigateToProfileScreen = { weight, height ->
                        navController.navigate(Screen.ProfileScreen.createRoute(weight, height))
                    }

                )
            }

            composable(Screen.MainScreen.route) { backStackEntry ->
                val weight = backStackEntry.arguments?.getString("weight") ?: ""
                val height = backStackEntry.arguments?.getString("height") ?: ""
                MainScreen(

                    weight = weight,
                    height = height,

                    onNavigateToNotification = {

                        navController.navigate(Screen.NotificationScreen.route)

                    },

                    onNavigateToProfile = {

                        navController.navigate(Screen.ProfileScreen.createRoute(weight, height))

                    }

                )

            }

            composable(Screen.NotificationScreen.route) {
                NotificationScreen(

                    onNavigateBack = {

                        navController.popBackStack()

                    }

                )
            }

            composable(Screen.ProfileScreen.route) { backStackEntry ->
                val weight = backStackEntry.arguments?.getString("weight") ?: ""
                val height = backStackEntry.arguments?.getString("height") ?: ""
                ProfileScreen(weight = weight, height = height)
            }

            composable(Screen.StepTracker.route) {
                StepTrackerScreen(
                    onNavigateBack = {
                        navController.popBackStack()
                    }
                )
            }


        }
    }
}

@Composable
@Preview(showBackground = true)
fun AppPreview() {
    val navController = rememberNavController()
    AppNavHost(navController = navController)
}
