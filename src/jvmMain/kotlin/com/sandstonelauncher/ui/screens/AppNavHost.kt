package com.sandstonelauncher.ui.screens

import androidx.compose.runtime.Composable
import com.sandstonelauncher.ui.ViewState
import com.sandstonelauncher.ui.screens.editProfile.EditProfileScreen
import com.sandstonelauncher.ui.screens.home.HomeScreen

@Composable
fun AppNavHost(navController: NavController, viewState: ViewState) {

    when (navController.currentScreen.value) {
        Screen.EditProfile -> {
            viewState.backButton = true
            viewState.secondTitle = "Edycja Profilu"

            EditProfileScreen(navController)
        }

        Screen.Home -> {
            viewState.backButton = false
            viewState.secondTitle = null

            HomeScreen(navController)
        }
    }

}