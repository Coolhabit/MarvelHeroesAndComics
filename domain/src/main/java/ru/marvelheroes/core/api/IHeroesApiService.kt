package ru.marvelheroes.core.api

import ru.marvelheroes.entities.dto.hero.Hero

interface IHeroesApiService {

    suspend fun loadHeroesList(): List<Hero>
}
