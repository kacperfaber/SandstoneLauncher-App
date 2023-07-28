package com.sandstonelauncher.storage

import com.sandstonelauncher.services.gameversion.GameVersion

object GameVersionStorage {
    var gameVersions: MutableList<GameVersion>? = null

    /**
     * resets GameVersionStorage.gameVersions and MinecraftGameVersionStorage.minecraftGameVersions
     * and forces reload this data, when they will be wanted again.
     */
    fun resetAll() {
        gameVersions = null
        MinecraftGameVersionStorage.minecraftGameVersions = null
    }
}