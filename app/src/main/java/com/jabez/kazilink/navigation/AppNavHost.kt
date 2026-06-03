package com.jabez.kazilink.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.jabez.kazilink.screens.login.LoginScreen
import com.jabez.kazilink.screens.splash.SplashScreen
import com.jabez.kazilink.screens.forgotpassword.ForgotPasswordScreen

@Composable
fun AppNavHost() {

    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = ROUTE_SPLASH
    ) {

        composable(ROUTE_SPLASH) {
            SplashScreen(navController)
        }

        composable(ROUTE_LOGIN) {
            LoginScreen(navController)
        }

        composable(ROUTE_FORGOT_PASSWORD) {
            ForgotPasswordScreen(navController)
        }

    }
}