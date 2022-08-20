package ru.marvelheroes.usecases

import androidx.paging.PagingSource
import ru.marvelheroes.core.api.IComicsApiService
import ru.marvelheroes.entities.dto.series.Series
import javax.inject.Inject

class ComicsUseCase @Inject constructor(
    private val api: IComicsApiService,
) {
    fun loadComicsList(): PagingSource<Int, Series> {
        return api.loadComicsList()
    }
}
