package com.sandstonelauncher.ui.screens.editProfile

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import com.sandstonelauncher.data.LauncherProfile
import com.sandstonelauncher.services.consoleapi.ConsoleApiService
import org.koin.java.KoinJavaComponent

class EditProfileScreenViewModel {
    private val consoleApiService by KoinJavaComponent.inject<ConsoleApiService>(ConsoleApiService::class.java)

    var launcherProfile by mutableStateOf<LauncherProfile?>(null)
        private set

    suspend fun loadProfileByName(profileName: String) {
        launcherProfile = consoleApiService.getLauncherProfile(profileName)
    }
}