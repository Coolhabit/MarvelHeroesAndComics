package ru.marvelheroes.core.api

import ru.marvelheroes.entities.dto.hero.Hero

interface IDatabaseStorage {

    fun addHeroToFavourite(hero: Hero)

    fun removeHeroFromFavourite(hero: Hero)

    fun getFavouriteHeroes(): List<Hero>
}
