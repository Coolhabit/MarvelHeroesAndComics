package ru.marvelheroes.usecases

import ru.marvelheroes.core.api.IHeroesApiService
import ru.marvelheroes.entities.dto.hero.Hero
import javax.inject.Inject

class HeroesUseCase @Inject constructor(
    private val api: IHeroesApiService,
) {
    suspend fun loadHeroesList(): List<Hero> {
        return api.loadHeroesList()
    }
}
