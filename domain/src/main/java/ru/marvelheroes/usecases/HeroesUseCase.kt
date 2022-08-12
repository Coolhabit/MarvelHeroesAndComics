package ru.marvelheroes.usecases

import androidx.paging.PagingSource
import ru.marvelheroes.core.api.IDatabaseStorage
import ru.marvelheroes.core.api.IHeroesApiService
import ru.marvelheroes.entities.dto.hero.Hero
import javax.inject.Inject

class HeroesUseCase @Inject constructor(
    private val api: IHeroesApiService,
    private val database: IDatabaseStorage,
) {
    fun loadHeroesList(): PagingSource<Int, Hero> {
        return api.loadHeroesList()
    }

    suspend fun addHeroToFavourite(hero: Hero) {
        database.addHeroToFavourite(hero)
    }

    suspend fun removeHeroFromFavourite(hero: Hero) {
        database.removeHeroFromFavourite(hero)
    }

    suspend fun getFavouriteHeroes(): List<Hero> {
        return database.getFavouriteHeroes()
    }
}
