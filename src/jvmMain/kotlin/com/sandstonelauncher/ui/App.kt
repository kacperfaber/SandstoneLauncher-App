package com.sandstonelauncher.ui

import androidx.compose.desktop.ui.tooling.preview.Preview
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.sandstonelauncher.AppTheme
import com.sandstonelauncher.ui.screens.AppNavHost
import com.sandstonelauncher.ui.screens.rememberNavController

@Composable
@Preview
fun App() {
    val navController = rememberNavController()

    AppTheme {
        Scaffold { paddingValues ->
            Box(Modifier.padding(paddingValues)) {
                AppNavHost(navController)
            }
        }
    }
}