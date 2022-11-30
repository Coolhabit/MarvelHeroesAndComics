package ru.marvelheroes.core.api

import kotlinx.coroutines.flow.Flow
import ru.marvelheroes.entities.dto.hero.Hero

interface IDatabaseStorage {

    suspend fun addHeroToFavourite(hero: Hero)

    suspend fun removeHeroFromFavourite(hero: Hero)

    fun getFavouriteHeroes(): Flow<List<Hero>>
}
