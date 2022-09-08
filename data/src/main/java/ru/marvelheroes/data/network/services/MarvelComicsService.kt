package ru.marvelheroes.data.network.services

import androidx.paging.Pager
import androidx.paging.PagingConfig
import ru.marvelheroes.core.api.IComicsApiService
import ru.marvelheroes.data.mappers.toComicDetails
import ru.marvelheroes.data.network.MarvelApi
import ru.marvelheroes.data.mappers.toHeroDetailComics
import ru.marvelheroes.data.mappers.toHeroDetailSeries
import ru.marvelheroes.data.network.paging.SeriesPagingSource
import ru.marvelheroes.entities.dto.books.Comics
import ru.marvelheroes.entities.dto.comics.ComicDetail
import ru.marvelheroes.entities.dto.books.Series
import ru.marvelheroes.extensions.NETWORK_PAGE_SIZE

class MarvelComicsService(
    private val api: MarvelApi,
) : IComicsApiService {

    override fun loadComicsList() = Pager(
        config = PagingConfig(pageSize = NETWORK_PAGE_SIZE),
        pagingSourceFactory = { SeriesPagingSource(api) }
    ).flow

    override suspend fun loadDetailSeriesList(heroId: String): List<Series> {
        return api.getSeriesByHeroId(heroId).data.results.map {
            it.toHeroDetailSeries()
        }
    }

    override suspend fun loadDetailComicsList(heroId: String): List<Comics> {
        return api.getComicsByHeroId(heroId).data.results.map {
            it.toHeroDetailComics()
        }
    }

    override suspend fun loadComicDetails(comicId: String): List<ComicDetail> {
        return api.getComicDetails(comicId).data.results.map {
            it.toComicDetails()
        }
    }
}
