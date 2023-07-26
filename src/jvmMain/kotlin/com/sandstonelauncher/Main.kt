package com.sandstonelauncher

import androidx.compose.desktop.ui.tooling.preview.Preview
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application
import com.sandstonelauncher.di.configDi

@Composable
@Preview
fun App() {
    AppTheme {
        Scaffold {

        }
    }
}

fun main() {
    configDi()

    application {
        Window(onCloseRequest = ::exitApplication) {
            App()
        }
    }
}
