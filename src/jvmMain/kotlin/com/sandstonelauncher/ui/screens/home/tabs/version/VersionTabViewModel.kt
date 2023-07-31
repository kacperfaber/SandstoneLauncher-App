package com.sandstonelauncher.ui.screens.home.tabs.version

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import com.sandstonelauncher.services.gameversion.GameVersion
import com.sandstonelauncher.services.gameversion.GameVersionService
import org.koin.java.KoinJavaComponent

class VersionTabViewModel {
    private val gameVersionService by KoinJavaComponent.inject<GameVersionService>(GameVersionService::class.java)

    var gameVersions by mutableStateOf<List<GameVersion>?>(null)
        private set

    var showOnlyInstalledVersions by mutableStateOf(true)

    var showSnapshots by mutableStateOf(false)

    var showRelease by mutableStateOf(true)

    suspend fun loadGameVersions() {
        gameVersions = gameVersionService.getGameVersions()
    }
}