package ru.marvelheroes.core.api

import androidx.paging.PagingSource
import ru.marvelheroes.entities.dto.comics.Comics

interface IComicsApiService {

    fun loadComicsList(): PagingSource<Int, Comics>
}
