package ru.marvelheroes.data.network.services

import androidx.paging.PagingSource
import ru.marvelheroes.core.api.IHeroesApiService
import ru.marvelheroes.data.db.dao.HeroesDao
import ru.marvelheroes.data.db.entities.toData
import ru.marvelheroes.data.network.paging.HeroesPagingSource
import ru.marvelheroes.entities.dto.hero.Hero

class MarvelHeroesService(
    private val heroesPagingSourceFactory: HeroesPagingSource.Factory,
) : IHeroesApiService {

    override fun loadHeroesList(): PagingSource<Int, Hero> {
        return heroesPagingSourceFactory.create()
    }
}
