package com.sandstonelauncher.services.minecraftapi

data class MinecraftVersionManifest(
    val latest: Latest,
    val versions: List<MinecraftGameVersion>
) {
    class Latest(val release: String, val snapshot: String)
}