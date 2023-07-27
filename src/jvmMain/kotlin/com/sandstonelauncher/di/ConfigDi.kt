package com.sandstonelauncher.di

import com.sandstonelauncher.Profile
import com.sandstonelauncher.currentProfile
import org.koin.core.context.startKoin
import org.koin.ksp.generated.module

fun profileDependantModule() = if (currentProfile == Profile.PROD) prodModule() else devModule()

fun configDi() {
    startKoin {
        modules(AppModule().module, profileDependantModule(), commonModule())
    }
}