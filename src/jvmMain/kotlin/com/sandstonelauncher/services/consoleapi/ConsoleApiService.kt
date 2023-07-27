package com.sandstonelauncher.services.consoleapi

import com.sandstonelauncher.data.LauncherProfile
import com.sandstonelauncher.services.consoleapi.wrapper.ConsoleApiWrapper
import org.koin.core.annotation.Single

@Single
class ConsoleApiService(private val consoleApiWrapper: ConsoleApiWrapper) {
    suspend fun getLauncherProfiles(): List<LauncherProfile> = consoleApiWrapper.listProfiles()
}