package ru.marvelheroes.data

import ru.marvelheroes.core.api.IHeroesApiService
import ru.marvelheroes.core.api.MarvelApi
import ru.marvelheroes.entities.dto.hero.Hero

class MarvelHeroesService(private val api: MarvelApi) : IHeroesApiService {

    override suspend fun loadHeroesList(): List<Hero> {
       val result =  api.getHeroes().data.results.map {
            Hero(
                heroId = it.id,
                heroName = it.name,
                heroPoster = "${it.thumbnail.path}.${it.thumbnail.extension}"
            )
        }
        return result
    }
}
