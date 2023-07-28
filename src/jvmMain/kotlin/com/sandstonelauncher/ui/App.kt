package com.sandstonelauncher.ui

import androidx.compose.desktop.ui.tooling.preview.Preview
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.window.WindowDraggableArea
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.window.WindowScope
import com.sandstonelauncher.AppTheme
import com.sandstonelauncher.ui.components.appbar.AppBar
import com.sandstonelauncher.ui.screens.AppNavHost
import com.sandstonelauncher.ui.screens.rememberNavController

@Composable
@Preview
fun WindowScope.App(exitApplication: () -> Unit, minimizeWindow: () -> Unit) {
    val navController = rememberNavController()
    val viewState = rememberViewState()

    AppTheme {
        Column(Modifier.fillMaxSize()) {
            WindowDraggableArea {
                AppBar(
                    exit = exitApplication,
                    minimize = minimizeWindow,
                    goBack = { navController.navigateUp() },
                    viewState = viewState
                )
            }

            Scaffold { paddingValues ->
                Box(Modifier.padding(paddingValues)) {
                    AppNavHost(navController, viewState)
                }
            }
        }
    }
}