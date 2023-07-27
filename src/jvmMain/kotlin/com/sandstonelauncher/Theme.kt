package com.sandstonelauncher

import androidx.compose.material.MaterialTheme
import androidx.compose.material.darkColors
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

private val darkColorScheme = darkColors(
    background = Color(30, 30, 30), surface = Color(50, 50, 50), onSurface = Color(255, 255, 255)
)

val colorScheme = darkColorScheme

@Composable
fun AppTheme(a: @Composable () -> Unit) {
    MaterialTheme(colors = darkColorScheme, typography = typography) {
        a()
    }
}