package ru.marvelheroes.data.network

import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query
import ru.marvelheroes.data.network.entities.comics.detail.ComicDetailsResponse
import ru.marvelheroes.data.network.entities.heroes.HeroesResponse
import ru.marvelheroes.data.network.entities.heroes.detail.HeroDetailsResponse
import ru.marvelheroes.data.network.entities.heroes.detail.comics.HeroDetailsComicsResponse
import ru.marvelheroes.data.network.entities.heroes.detail.series.HeroDetailsSeriesResponse
import ru.marvelheroes.data.network.entities.series.SeriesResponse

interface MarvelApi {
    @GET("/v1/public/characters")
    suspend fun getHeroes(
        @Query("offset") offset: Int,
        @Query("limit") limit: Int,
        @Query("nameStartsWith") query: String?
    ): Response<HeroesResponse>

    @GET("/v1/public/comics")
    suspend fun getComics(
        @Query("offset") offset: Int,
        @Query("limit") limit: Int,
        @Query("titleStartsWith") query: String?
    ): Response<SeriesResponse>

    @GET("/v1/public/characters/{characterId}")
    suspend fun getHeroDetails(
        @Path("characterId") characterId: String,
    ): HeroDetailsResponse

    @GET("/v1/public/characters/{characterId}/comics")
    suspend fun getComicsByHeroId(
        @Path("characterId") characterId: String,
    ): HeroDetailsComicsResponse

    @GET("/v1/public/characters/{characterId}/series")
    suspend fun getSeriesByHeroId(
        @Path("characterId") characterId: String,
    ): HeroDetailsSeriesResponse

    @GET("/v1/public/comics/{comicId}")
    suspend fun getComicDetails(
        @Path("comicId") comicId: String,
    ): ComicDetailsResponse
}
