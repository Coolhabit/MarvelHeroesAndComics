package ru.marvelheroes.usecases

import kotlinx.coroutines.flow.Flow
import ru.marvelheroes.core.api.IDatabaseStorage
import ru.marvelheroes.entities.dto.hero.Hero
import javax.inject.Inject

class MyAvengersUseCase @Inject constructor(
    private val database: IDatabaseStorage,

) {

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
