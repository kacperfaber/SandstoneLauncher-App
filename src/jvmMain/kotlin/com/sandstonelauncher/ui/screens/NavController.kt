package com.sandstonelauncher.ui.screens

import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember

class NavController {
    var currentScreen = mutableStateOf(Screen.Home)
    private var currentArgs = mutableStateOf<Map<String, String?>?>(null)

    fun navigate(screen: Screen) {
        currentScreen.value = screen
        currentArgs.value = null
    }

    fun navigate(screen: Screen, map: Map<String, String?>) {
        navigate(screen)
        currentArgs.value = map
    }

    fun getStringArg(key: String): String? {
        return currentArgs.value?.get(key)
    }
}

@Composable
fun rememberNavController(): NavController {
    return remember { mutableStateOf(NavController()) }.value
}