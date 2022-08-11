package ru.marvelheroes.data.network.services

import androidx.paging.PagingSource
import ru.marvelheroes.core.api.IComicsApiService
import ru.marvelheroes.data.network.paging.ComicsPagingSource
import ru.marvelheroes.entities.dto.comics.Comics

class MarvelComicsService(private val comicsPagingSourceFactory: ComicsPagingSource.Factory):
    IComicsApiService {

    override fun loadComicsList(): PagingSource<Int, Comics> {
        return comicsPagingSourceFactory.create()
    }
}
