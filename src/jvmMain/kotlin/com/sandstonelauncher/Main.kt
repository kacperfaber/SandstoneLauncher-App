package com.sandstonelauncher

import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application
import com.sandstonelauncher.di.configDi
import com.sandstonelauncher.ui.App

fun main() {
    configDi()

    application {
        Window(onCloseRequest = ::exitApplication) {
            App()
        }
    }
}
