package com.sandstonelauncher

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.window.WindowDraggableArea
import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application
import androidx.compose.ui.window.rememberWindowState
import com.sandstonelauncher.di.configDi
import com.sandstonelauncher.ui.App
import com.sandstonelauncher.ui.components.appbar.AppBar

fun main() {
    configDi()

    application {
        val windowState = rememberWindowState()

        Window(onCloseRequest = ::exitApplication, undecorated = true, state = windowState) {
            AppTheme {
                Column {
                    WindowDraggableArea {
                        AppBar(
                            exit = {exitApplication()},
                            minimize = {windowState.isMinimized = true}
                        )
                    }

                    App()
                }
            }
        }
    }
}
