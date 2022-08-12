package ru.marvelheroes.usecases

import androidx.paging.PagingData
import kotlinx.coroutines.flow.Flow
import ru.marvelheroes.core.api.IDatabaseStorage
import ru.marvelheroes.core.api.IHeroesApiService
import ru.marvelheroes.entities.dto.hero.Hero
import javax.inject.Inject

class HeroesUseCase @Inject constructor(
    private val api: IHeroesApiService,
    private val database: IDatabaseStorage,
) {
    fun loadHeroesList(): Flow<PagingData<Hero>> {
        return api.loadHeroesList()
    }

    suspend fun addHeroToFavourite(hero: Hero) {
        database.addHeroToFavourite(hero)
    }

    suspend fun removeHeroFromFavourite(hero: Hero) {
        database.removeHeroFromFavourite(hero)
    }

    fun getFavouriteHeroes(): Flow<List<Hero>> {
        return database.getFavouriteHeroes()
    }
}
