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
            Row(Modifier.padding(paddingValues)) {
                Box(Modifier.fillMaxSize().weight(.33f)) {
                    ProfileList()
                }

                Box(Modifier.background(colorScheme.primary).fillMaxSize().weight(.67f)) {

                }
            }
        }
    }
}