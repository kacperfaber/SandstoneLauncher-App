package com.sandstonelauncher.ui

import androidx.compose.desktop.ui.tooling.preview.Preview
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.sandstonelauncher.AppTheme
import com.sandstonelauncher.colorScheme
import com.sandstonelauncher.ui.components.profilelist.ProfileList

@Composable
@Preview
fun App() {
    AppTheme {
        Scaffold { paddingValues ->
            Box(Modifier.padding(paddingValues)) {

            }
        }
    }
}