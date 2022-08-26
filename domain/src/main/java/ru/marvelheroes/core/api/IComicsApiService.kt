package ru.marvelheroes.core.api

import androidx.paging.PagingData
import androidx.paging.PagingSource
import kotlinx.coroutines.flow.Flow
import ru.marvelheroes.entities.dto.hero.Hero
import ru.marvelheroes.entities.dto.series.Series

interface IComicsApiService {

    fun loadComicsList(): Flow<PagingData<Series>>

    suspend fun loadDetailSeriesList(heroId: String): List<Series>

    suspend fun loadDetailComicsList(heroId: String): List<Series>
}
