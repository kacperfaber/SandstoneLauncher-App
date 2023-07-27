package com.sandstonelauncher.di

import com.fasterxml.jackson.databind.ObjectMapper
import org.koin.dsl.module

private fun objectMapper() = ObjectMapper()

internal fun commonModule() = module{
    single { objectMapper() }
}