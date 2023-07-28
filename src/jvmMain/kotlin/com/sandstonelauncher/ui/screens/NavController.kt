package com.sandstonelauncher.ui.screens

import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember

class NavController {
    var currentScreen = mutableStateOf(Screen.Home)

    fun navigate(screen: Screen) {
        currentScreen.value = screen
    }
}

@Composable
fun rememberNavController(): NavController {
    return remember { mutableStateOf(NavController()) }.value
}