package com.sandstonelauncher.services.consoleapi.wrapper

import com.sandstonelauncher.data.LauncherProfile

interface ConsoleApiWrapper {
    suspend fun listProfiles(): List<LauncherProfile>
    suspend fun createProfile(profile: LauncherProfile)
    suspend fun deleteProfile(name: String)

    // TODO: 3/10 commands [12:00 27-07-2023].

    suspend fun updateProfile(launcherProfile: LauncherProfile)
}