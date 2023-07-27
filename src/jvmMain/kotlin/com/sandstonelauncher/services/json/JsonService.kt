package com.sandstonelauncher.services.json

import com.fasterxml.jackson.databind.ObjectMapper
import org.koin.core.annotation.Single

@Single
class JsonService(private val objectMapper: ObjectMapper) {
    fun serialize(d: Any): String {
        return objectMapper.writeValueAsString(d)
    }

    fun <T> deserialize(json: String, cl: Class<T>): T {
        return objectMapper.readValue(json, cl)
    }
}