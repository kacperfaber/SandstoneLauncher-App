package com.sandstonelauncher.ui.components.versionlist

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.sandstonelauncher.services.gameversion.GameVersion

@Composable
fun VersionList(modifier: Modifier = Modifier, versions: List<GameVersion>, header: @Composable () -> Unit = {}) {
    LazyColumn(modifier) {
        item {
            header()
        }

        items(versions) { version ->
            VersionListItem(version.version.id, version.isInstalled)
        }
    }
}