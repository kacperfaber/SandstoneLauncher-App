package com.sandstonelauncher.services.consoleapi.wrapper

import com.sandstonelauncher.data.LauncherProfile

// TODO: ProdConsoleApiWrapper not implemented.

class ProdConsoleApiWrapper : ConsoleApiWrapper {
    override suspend fun listProfiles(): List<LauncherProfile> {
        TODO("Not yet implemented")
    }

    override suspend fun createProfile(profile: LauncherProfile) {
        TODO("Not yet implemented")
    }

    override suspend fun deleteProfile(name: String) {
        TODO("Not yet implemented")
    }
}