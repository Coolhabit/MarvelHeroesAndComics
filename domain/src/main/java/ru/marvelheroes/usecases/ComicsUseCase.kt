package ru.marvelheroes.usecases

import androidx.paging.PagingData
import androidx.paging.PagingSource
import kotlinx.coroutines.flow.Flow
import ru.marvelheroes.core.api.IComicsApiService
import ru.marvelheroes.entities.dto.hero.Hero
import ru.marvelheroes.entities.dto.series.Series
import javax.inject.Inject

class ComicsUseCase @Inject constructor(
    private val api: IComicsApiService,
) {
    fun loadComicsList(): Flow<PagingData<Series>> {
        return api.loadComicsList()
    }
}
