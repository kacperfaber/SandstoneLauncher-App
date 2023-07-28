package com.sandstonelauncher.ui.screens.home.tabs.version

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import com.sandstonelauncher.ui.components.versionlist.VersionList

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

    if (vm.gameVersions != null) {
        VersionList(Modifier.fillMaxSize(), vm.gameVersions!!)
    }
}