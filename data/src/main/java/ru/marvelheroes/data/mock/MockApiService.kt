package ru.marvelheroes.data.mock

import androidx.paging.PagingData
import androidx.paging.PagingSource
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import ru.marvelheroes.core.api.IHeroesApiService
import ru.marvelheroes.entities.dto.hero.Hero

class MockApiService : IHeroesApiService {

    override fun loadHeroesList(): Flow<PagingData<Hero>> {
        TODO("Not yet implemented")
    }
}
