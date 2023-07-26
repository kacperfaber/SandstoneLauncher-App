package com.sandstonelauncher.di

import org.koin.core.context.startKoin
import org.koin.ksp.generated.module

fun configDi() {
    startKoin {
        modules(AppModule().module)
    }
}