package com.sandstonelauncher.ui.screens

import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember

class NavController {
    class RouterException : Exception()

    class BackStackEntry(val screen: Screen, val args: Map<String, String?>?)

    var currentScreen = mutableStateOf(Screen.Home)
    private var currentArgs = mutableStateOf<Map<String, String?>?>(null)
    private var backStack = mutableListOf<BackStackEntry>()

    private fun registerBackStackEntry() {
        backStack.add(BackStackEntry(currentScreen.value, currentArgs.value))
    }

    private fun dropLastStackEntry(): BackStackEntry {
        return backStack.removeLast()
    }

    private fun loadBackStackEntry(entry: BackStackEntry) {
        currentScreen.value = entry.screen
        currentArgs.value = entry.args
    }

    fun navigate(screen: Screen) {
        registerBackStackEntry()
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

    fun navigateUp() {
        val lastEntry = dropLastStackEntry()
        loadBackStackEntry(lastEntry)
    }

    fun requireString(key: String): String {
        return currentArgs.value?.get(key) ?: throw RouterException()
    }
}

@Composable
fun rememberNavController(): NavController {
    return remember { mutableStateOf(NavController()) }.value
}