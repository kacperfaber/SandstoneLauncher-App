package com.sandstonelauncher.services.httpclient

import com.sandstonelauncher.services.json.JsonService
import io.ktor.client.*
import io.ktor.client.engine.cio.*
import io.ktor.client.request.*
import io.ktor.client.statement.*
import org.koin.core.annotation.Single

@Single
class HttpClientService(private val jsonService: JsonService) {
    private val http = HttpClient(CIO)

    suspend fun <T> getAsync(url: String, cl: Class<T>): T {
        val json = http.get(url).bodyAsText()
        return jsonService.deserialize(json, cl)
    }
}