package com.sandstonelauncher.di

import com.sandstonelauncher.services.consoleapi.wrapper.DevConsoleApiWrapper
import org.koin.dsl.module

internal fun devModule() = module {
    single { DevConsoleApiWrapper() }
}
