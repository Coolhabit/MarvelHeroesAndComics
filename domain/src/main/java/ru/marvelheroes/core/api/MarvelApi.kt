package ru.marvelheroes.core.api

import retrofit2.http.GET
import ru.marvelheroes.entities.MarvelApiResponse

private const val API_KEY = "api_key"

interface MarvelApi {
    @GET("/v1/public/characters")
    suspend fun getHeroes(): MarvelApiResponse
}
