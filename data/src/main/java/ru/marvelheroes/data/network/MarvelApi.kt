package ru.marvelheroes.data.network

import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query
import ru.marvelheroes.data.network.entities.comics.ComicsResponse
import ru.marvelheroes.data.network.entities.heroes.HeroesResponse

interface MarvelApi {
    @GET("/v1/public/characters")
    suspend fun getHeroes(
        @Query("offset") offset: Int,
        @Query("limit") limit: Int
    ): Response<HeroesResponse>

    @GET("/v1/public/comics")
    suspend fun getComics(
        @Query("offset") offset: Int,
        @Query("limit") limit: Int
    ): Response<ComicsResponse>
}
