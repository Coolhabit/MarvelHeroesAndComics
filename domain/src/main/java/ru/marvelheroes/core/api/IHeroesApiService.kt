package ru.marvelheroes.core.api

import androidx.paging.PagingData
import kotlinx.coroutines.flow.Flow
import ru.marvelheroes.entities.dto.hero.Hero
import ru.marvelheroes.entities.dto.hero.HeroDetail

interface IHeroesApiService {

    fun loadHeroesList(): Flow<PagingData<Hero>>

    suspend fun loadHeroDetail(heroId: String): HeroDetail
}
