package ru.marvelheroes.core.api

import ru.marvelheroes.entities.dto.hero.Hero

interface IDatabaseStorage {

    suspend fun addHeroToFavourite(hero: Hero)

    suspend fun removeHeroFromFavourite(hero: Hero)

    suspend fun getFavouriteHeroes(): List<Hero>
}
