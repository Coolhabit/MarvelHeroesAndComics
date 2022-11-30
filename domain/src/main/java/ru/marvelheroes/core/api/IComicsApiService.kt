package ru.marvelheroes.core.api

import androidx.paging.PagingData
import kotlinx.coroutines.flow.Flow
import ru.marvelheroes.entities.dto.books.Comics
import ru.marvelheroes.entities.dto.comics.ComicDetail
import ru.marvelheroes.entities.dto.books.Series

interface IComicsApiService {

    fun loadComicsList(query: String?): Flow<PagingData<Series>>

    suspend fun loadDetailSeriesList(heroId: String): List<Series>

    suspend fun loadDetailComicsList(heroId: String): List<Comics>

    suspend fun loadComicDetails(comicId: String): List<ComicDetail>
}
