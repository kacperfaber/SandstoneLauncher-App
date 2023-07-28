package com.sandstonelauncher

import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application
import androidx.compose.ui.window.rememberWindowState
import com.sandstonelauncher.di.configDi
import com.sandstonelauncher.ui.App

fun main() {
    configDi()

    application {
        val windowState = rememberWindowState()

        Window(onCloseRequest = ::exitApplication, undecorated = true, state = windowState) {
            App(
                exitApplication = ::exitApplication,
                minimizeWindow = {windowState.isMinimized = true}
            )
        }
    }
}
