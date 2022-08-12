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

    fun addHeroToFavourite(hero: Hero) {
        database.addHeroToFavourite(hero)
    }

    fun removeHeroFromFavourite(hero: Hero) {
        database.removeHeroFromFavourite(hero)
    }

    fun getFavouriteHeroes(): List<Hero> {
        return database.getFavouriteHeroes()
    }
}
