package com.sandstonelauncher.ui.components.profilelist

import androidx.compose.desktop.ui.tooling.preview.Preview
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Text
import androidx.compose.runtime.*

@Composable
fun ProfileList(onProfileSettingsClicked: (profileName: String) -> Unit) {
    val viewModel by remember { mutableStateOf(ProfileListViewModel()) }

    var selectedItemName by remember { mutableStateOf<String?>(null) }

    LaunchedEffect(Unit) {
        viewModel.refreshProfiles()
    }

    LazyColumn {
        if (viewModel.launcherProfiles != null) {
            items(viewModel.launcherProfiles!!) { launcherProfile ->
                ProfileItem(
                    name = launcherProfile.name,
                    versionId = launcherProfile.lastVersionId,
                    isSelected = launcherProfile.name == selectedItemName,
                    onClick = { selectedItemName = launcherProfile.name },
                    onSettingsClicked = {onProfileSettingsClicked(launcherProfile.name)}
                )
            }
        } else {
            item { Text("Loading...") } // TODO: Text internationalization
        }
    }
}