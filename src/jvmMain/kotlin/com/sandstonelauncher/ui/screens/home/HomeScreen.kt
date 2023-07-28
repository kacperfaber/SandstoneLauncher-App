package com.sandstonelauncher.ui.screens.home

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.sandstonelauncher.colorScheme
import com.sandstonelauncher.ui.components.profilelist.ProfileList
import com.sandstonelauncher.ui.screens.NavController
import com.sandstonelauncher.ui.screens.editProfile

@Composable
fun HomeScreen(navController: NavController) {
    Row(Modifier.fillMaxSize()) {
        Box(Modifier.fillMaxSize().weight(.33f)) {
            ProfileList(
                onProfileSettingsClicked = { name -> navController.editProfile(name) }
            )
        }

        Box(Modifier.background(colorScheme.background).fillMaxSize().weight(.67f)) {

        }
    }
}