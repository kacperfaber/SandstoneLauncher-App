package com.sandstonelauncher.ui.screens.home.tabs.version

import androidx.compose.foundation.layout.*
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.sandstonelauncher.services.gameversion.GameVersion
import com.sandstonelauncher.ui.components.versionlist.VersionList
import com.sandstonelauncher.ui.components.versionlist.filterbar.FilterBar

@Composable
private fun OptionalVersionList(modifier: Modifier, versions: List<GameVersion>?, header: @Composable () -> Unit) {
    if (versions != null) {
        VersionList(
            modifier = modifier,
            versions = versions,
            header = header,
            onDownloadVersion = { TODO("Download Version not implemented.") }
        )
    } else {
        Row(
            modifier = Modifier.fillMaxSize(),
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically
        ) {
            CircularProgressIndicator(Modifier.width(50.dp).height(50.dp))
        }
    }
}

@Composable
fun VersionTab() {
    val vm by remember { mutableStateOf(VersionTabViewModel()) }

    /*
    TODO: version list is too long...
     I have two ideas:
     - filter buttons, but I don't know where.
     - separate to two list [installed, can be installed]
     */

    LaunchedEffect(Unit) {
        vm.loadGameVersions()
    }

    Column(Modifier.fillMaxSize()) {
        FilterBar(vm)

        if (vm.showOnlyInstalledVersions) {
            OptionalVersionList(
                modifier = Modifier.fillMaxSize(),
                versions = vm.gameVersions?.filter { it.isInstalled },
                header = { Text("Only installed versions", style = MaterialTheme.typography.h3) }
            )
        }

        else {
            val filteredGameVersions = vm.gameVersions!!.filter {
                (it.version.type == "release" && vm.showRelease) || (it.version.type == "snapshot" && vm.showSnapshots)
            }

            OptionalVersionList(
                modifier = Modifier.fillMaxSize(),
                versions = filteredGameVersions,
                header = { Text("Game Versions", style = MaterialTheme.typography.h3) }
            )
        }
    }
}