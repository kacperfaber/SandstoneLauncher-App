package com.sandstonelauncher.services.minecraftapi

import com.sandstonelauncher.services.httpclient.HttpClientService
import org.koin.core.annotation.Single

@Single
class MinecraftApiService(private val httpClientService: HttpClientService) {
    private val versionManifestUrl = "https://launchermeta.mojang.com/mc/game/version_manifest.json"

    suspend fun getVersions(): List<MinecraftGameVersion> {
        return httpClientService.getAsync(versionManifestUrl, MinecraftVersionManifest::class.java).versions
    }
}