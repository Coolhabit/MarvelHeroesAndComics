package ru.marvelheroes.usecases

import androidx.paging.PagingSource
import ru.marvelheroes.core.api.IComicsApiService
import ru.marvelheroes.entities.dto.comics.Comics
import javax.inject.Inject

class ComicsUseCase @Inject constructor(
    private val api: IComicsApiService,
) {
    fun loadComicsList(): PagingSource<Int, Comics> {
        return api.loadComicsList()
    }
}
