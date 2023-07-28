package com.sandstonelauncher.ui.viewmodels

import androidx.compose.runtime.mutableStateOf
import com.sandstonelauncher.data.LauncherProfile
import com.sandstonelauncher.services.consoleapi.ConsoleApiService
import org.koin.java.KoinJavaComponent.inject

class EditLauncherProfileViewModel(private val launcherProfile: LauncherProfile) {
    private val consoleApiService by inject<ConsoleApiService>(ConsoleApiService::class.java)

    var profileName = mutableStateOf(launcherProfile.name)
    var gameDir = mutableStateOf(launcherProfile.gameDir)
    var javaDir = mutableStateOf(launcherProfile.javaDir)
    var javaArgs = mutableStateOf(launcherProfile.javaArgs)
    var lastVersionId = mutableStateOf(launcherProfile.javaArgs)
    var resolutionW = mutableStateOf(launcherProfile.resolution.width)
    var resolutionH = mutableStateOf(launcherProfile.resolution.height)

    suspend fun saveProfile() {
        launcherProfile.name = profileName.value
        launcherProfile.gameDir = gameDir.value
        launcherProfile.javaDir = javaDir.value
        launcherProfile.javaArgs = javaArgs.value
        launcherProfile.lastVersionId = lastVersionId.value
        launcherProfile.resolution.height = resolutionH.value
        launcherProfile.resolution.width = resolutionW.value

        consoleApiService.updateProfile(launcherProfile)
    }
}