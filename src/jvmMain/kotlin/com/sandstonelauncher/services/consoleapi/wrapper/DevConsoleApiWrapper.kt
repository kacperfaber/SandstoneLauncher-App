package com.sandstonelauncher.services.consoleapi.wrapper

import com.sandstonelauncher.data.LauncherProfile
import com.sandstonelauncher.data.Resolution

class DevConsoleApiWrapper : ConsoleApiWrapper {
    private var profiles = mutableListOf(
        LauncherProfile("kacperek", "%APPDATA%\\.minecraft", "C:\\Users\\kacperfaber", "", Resolution(854, 480), "1.19.2"),
        LauncherProfile("mateuszek", "%APPDATA%\\.minecraft", "C:\\Users\\kacperfaber", "", Resolution(854, 480), "1.12")
    )

    override suspend fun listProfiles(): List<LauncherProfile> {
        return profiles
    }

    override suspend fun createProfile(profile: LauncherProfile) {
        profiles.add(profile)
    }

    override suspend fun deleteProfile(name: String) {
        profiles = profiles.filter { it.name != name }.toMutableList()
    }

    override suspend fun updateProfile(launcherProfile: LauncherProfile) {
        TODO("Not yet implemented")
    }
}