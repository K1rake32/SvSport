package com.example.svsport.ui.app.Navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.svsport.ui.app.screens.Auth.AuthMainScreen
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
    object StepTracker : Screen("step_tracker")
}

@Composable
fun AppNavHost(navController: NavHostController) {
    NavHost(
        navController = navController,
        startDestination = Screen.Welcome.route
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
                onNavigateToStepTracker = {
                    navController.navigate(Screen.StepTracker.route)
                }
            )
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

@Composable
@Preview(showBackground = true)
fun AppPreview() {
    val navController = rememberNavController()
    AppNavHost(navController = navController)
}