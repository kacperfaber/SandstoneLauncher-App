package com.sandstonelauncher.ui.screens

import androidx.compose.runtime.Composable
import com.sandstonelauncher.ui.screens.editProfile.EditProfileScreen
import com.sandstonelauncher.ui.screens.home.HomeScreen

@Composable
fun AppNavHost(navController: NavController) {

    when (navController.currentScreen.value) {
        Screen.EditProfile -> {
            EditProfileScreen(navController)
        }

        Screen.Home -> {
            HomeScreen(navController)
        }
    }

}