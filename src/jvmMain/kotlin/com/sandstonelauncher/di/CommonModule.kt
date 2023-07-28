package com.sandstonelauncher.di

import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import org.koin.dsl.module

private fun objectMapper() = jacksonObjectMapper()

internal fun commonModule() = module{
    single { objectMapper() }
}