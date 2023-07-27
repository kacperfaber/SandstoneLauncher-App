package com.sandstonelauncher.di

import com.sandstonelauncher.services.consoleapi.wrapper.ConsoleApiWrapper
import com.sandstonelauncher.services.consoleapi.wrapper.DevConsoleApiWrapper
import org.koin.dsl.bind
import org.koin.dsl.module

internal fun devModule() = module {
    single { DevConsoleApiWrapper() } bind ConsoleApiWrapper::class
}
