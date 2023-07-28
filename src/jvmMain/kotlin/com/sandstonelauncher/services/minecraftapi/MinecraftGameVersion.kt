package com.sandstonelauncher.services.minecraftapi

import java.time.LocalDateTime

data class MinecraftGameVersion(
    val id: String,
    val type: String,
    val url: String,
    val time: String,
    val releaseTime: String
)