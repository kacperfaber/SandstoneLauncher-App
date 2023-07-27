package com.sandstonelauncher.data

data class LauncherProfile(
        var name: String,
        var gameDir: String,
        var javaDir: String,
        var javaArgs: String,
        var resolution: Resolution,
        var lastVersionId: String
)