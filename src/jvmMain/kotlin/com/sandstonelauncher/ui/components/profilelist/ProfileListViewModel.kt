package com.sandstonelauncher.ui.components.profilelist

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import com.sandstonelauncher.data.LauncherProfile
import com.sandstonelauncher.services.consoleapi.ConsoleApiService
import org.koin.java.KoinJavaComponent.inject

class ProfileListViewModel {
    private val consoleApiService by inject<ConsoleApiService>(ConsoleApiService::class.java)

    var launcherProfiles by mutableStateOf<List<LauncherProfile>?>(null)
        private set

    suspend fun refreshProfiles() {
        launcherProfiles = consoleApiService.getLauncherProfiles()
    }
}