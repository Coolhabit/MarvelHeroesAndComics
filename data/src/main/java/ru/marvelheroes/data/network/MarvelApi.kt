package ru.marvelheroes.data.network

import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query
import ru.marvelheroes.data.network.entities.heroes.HeroesResponse
import ru.marvelheroes.data.network.entities.series.SeriesResponse

interface MarvelApi {
    @GET("/v1/public/characters")
    suspend fun getHeroes(
        @Query("offset") offset: Int,
        @Query("limit") limit: Int
    ): Response<HeroesResponse>

    @GET("/v1/public/series")
    suspend fun getSeries(
        @Query("offset") offset: Int,
        @Query("limit") limit: Int
    ): Response<SeriesResponse>
}
