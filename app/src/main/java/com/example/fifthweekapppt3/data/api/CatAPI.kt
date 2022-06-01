package com.example.fifthweekapppt3.data.api

import com.example.fifthweekapppt3.data.model.CatItem
import com.example.fifthweekapppt3.data.model.FavouriteCats
import io.ktor.client.*
import io.ktor.client.call.*
import io.ktor.client.engine.android.*
import io.ktor.client.engine.cio.*
import io.ktor.client.plugins.*
import io.ktor.client.plugins.contentnegotiation.*
import io.ktor.client.request.*
import io.ktor.client.statement.*
import io.ktor.http.*
import io.ktor.serialization.kotlinx.json.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import kotlinx.serialization.json.Json

object CatAPI {
    private const val API_KEY = "cb90513c-1d7b-420d-b14d-df1d7a6cfeca"
    const val API = "https://api.thecatapi.com/v1/images/search?$API_KEY"


    suspend fun getNewImage(): CatItem {
        return withContext(Dispatchers.IO) {
            val client = HttpClient(CIO) {
                install(ContentNegotiation) {
                    json(Json {
                        ignoreUnknownKeys = true
                    })
                }
            }
            val response: HttpResponse = client.get(API)
            client.close()
            return@withContext response.body<List<CatItem>>().first()
        }
    }

    suspend fun saveLike(item:FavouriteCats) {
        val client = HttpClient(CIO)
        val response: HttpResponse = client.post("https://api.thecatapi.com/v1/favourites") {
            headers{
                append("x-api-key","cb90513c-1d7b-420d-b14d-df1d7a6cfeca")
            }
            setBody("item")
        }

    }

}
