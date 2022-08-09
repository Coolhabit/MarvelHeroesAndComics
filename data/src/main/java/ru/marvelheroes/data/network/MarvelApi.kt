package ru.marvelheroes.data.network

import retrofit2.http.GET
import ru.marvelheroes.data.network.entities.MarvelApiResponse

interface MarvelApi {
    @GET("/v1/public/characters")
    suspend fun getHeroes(): MarvelApiResponse
}
