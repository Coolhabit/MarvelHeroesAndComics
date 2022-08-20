package ru.marvelheroes.data.network.services

import androidx.paging.PagingSource
import ru.marvelheroes.core.api.IComicsApiService
import ru.marvelheroes.data.network.paging.SeriesPagingSource
import ru.marvelheroes.entities.dto.series.Series

class MarvelComicsService(private val seriesPagingSourceFactory: SeriesPagingSource.Factory):
    IComicsApiService {

    override fun loadComicsList(): PagingSource<Int, Series> {
        return seriesPagingSourceFactory.create()
    }
}
