package ru.marvelheroes.core.api

import androidx.paging.PagingSource
import ru.marvelheroes.entities.dto.series.Series

interface IComicsApiService {

    fun loadComicsList(): PagingSource<Int, Series>
}
