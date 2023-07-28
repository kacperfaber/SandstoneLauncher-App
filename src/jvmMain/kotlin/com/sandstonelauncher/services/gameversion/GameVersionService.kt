package com.sandstonelauncher.services.gameversion

import com.sandstonelauncher.services.consoleapi.ConsoleApiService
import com.sandstonelauncher.services.minecraftapi.MinecraftApiService
import com.sandstonelauncher.services.minecraftapi.MinecraftGameVersion
import com.sandstonelauncher.storage.GameVersionStorage
import org.koin.core.annotation.Single

@Single
class GameVersionService(
    private val consoleApiService: ConsoleApiService,
    private val minecraftApiService: MinecraftApiService
) {
    suspend fun getGameVersions(): List<GameVersion> {
        return GameVersionStorage.gameVersions ?: fetchGameVersions()
    }

    suspend fun fetchGameVersions(): List<GameVersion> {
        val r = minecraftApiService.getVersions().createGameVersionList(consoleApiService.getInstalledVersions())
        GameVersionStorage.gameVersions = r.toMutableList()
        return r
    }

    private fun List<MinecraftGameVersion>.createGameVersionList(installedVersions: List<String>): List<GameVersion> =
        map { minecraftGameVersion ->
            GameVersion(minecraftGameVersion, installedVersions.any { it == minecraftGameVersion.id })
        }
}