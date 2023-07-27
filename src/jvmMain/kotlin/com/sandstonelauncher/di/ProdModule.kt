package com.sandstonelauncher.di

import com.sandstonelauncher.services.consoleapi.wrapper.ConsoleApiWrapper
import com.sandstonelauncher.services.consoleapi.wrapper.ProdConsoleApiWrapper
import org.koin.dsl.bind
import org.koin.dsl.module

internal fun prodModule() = module {
    single { ProdConsoleApiWrapper() } bind ConsoleApiWrapper::class
}