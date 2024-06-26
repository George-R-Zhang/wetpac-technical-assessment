package com.example.westpactechnicalassessment.utility

import kotlinx.serialization.SerializationException
import kotlinx.serialization.json.Json

object JsonUtils {

    val json: Json = Json {
        isLenient = true
        encodeDefaults = true
        ignoreUnknownKeys = true
    }

    // The type of T must be marked as @Serializable
    inline fun<reified T> fromJsonString(jsonString: String): T? {
        return try {
            json.decodeFromString(jsonString)
        } catch (e: SerializationException) {
            null
        }
    }
}