package com.sandstonelauncher.ui.screens

import androidx.compose.runtime.Composable
import com.sandstonelauncher.ui.screens.home.HomeScreen

@Composable
fun AppNavHost(navController: NavController) {

    when (navController.currentScreen.value) {
        Screen.ProfileSettings -> {

        }

        Screen.Home -> {
            HomeScreen(navController)
        }
    }

}