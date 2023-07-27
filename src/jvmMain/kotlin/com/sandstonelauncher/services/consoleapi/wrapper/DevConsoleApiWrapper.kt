package com.sandstonelauncher.services.consoleapi.wrapper

import com.sandstonelauncher.data.LauncherProfile

class DevConsoleApiWrapper : ConsoleApiWrapper {
    private var profiles = mutableListOf<LauncherProfile>()

    override suspend fun listProfiles(): List<LauncherProfile> {
        return profiles
    }

    override suspend fun createProfile(profile: LauncherProfile) {
        profiles.add(profile)
    }

    override suspend fun deleteProfile(name: String) {
        profiles = profiles.filter { it.name != name }.toMutableList()
    }
}