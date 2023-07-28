package com.sandstonelauncher.services.gameversion

import com.sandstonelauncher.services.minecraftapi.MinecraftGameVersion

data class GameVersion(
    val version: MinecraftGameVersion,
    val isInstalled: Boolean
)