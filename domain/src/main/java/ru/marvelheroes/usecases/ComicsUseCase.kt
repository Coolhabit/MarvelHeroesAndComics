package ru.marvelheroes.usecases

import androidx.paging.PagingData
import kotlinx.coroutines.flow.Flow
import ru.marvelheroes.core.api.IComicsApiService
import ru.marvelheroes.entities.dto.comics.ComicDetail
import ru.marvelheroes.entities.dto.books.Series
import javax.inject.Inject

class ComicsUseCase @Inject constructor(
    private val api: IComicsApiService,
) {
    fun loadComicsList(): Flow<PagingData<Series>> {
        return api.loadComicsList()
    }

    suspend fun loadComicsDetails(comicId: String): List<ComicDetail> {
        return api.loadComicDetails(comicId)
    }
}
