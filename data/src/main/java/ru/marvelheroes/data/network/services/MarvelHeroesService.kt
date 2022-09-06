package ru.marvelheroes.data.network.services

import androidx.paging.Pager
import androidx.paging.PagingConfig
import ru.marvelheroes.core.api.IHeroesApiService
import ru.marvelheroes.data.network.MarvelApi
import ru.marvelheroes.data.mappers.toHeroDetail
import ru.marvelheroes.data.network.paging.HeroesPagingSource
import ru.marvelheroes.entities.dto.hero.HeroDetail
import ru.marvelheroes.extensions.NETWORK_PAGE_SIZE

class MarvelHeroesService(
    private val api: MarvelApi,
) : IHeroesApiService {

    override fun loadHeroesList() = Pager(
        config = PagingConfig(pageSize = NETWORK_PAGE_SIZE),
        pagingSourceFactory = { HeroesPagingSource(api) }
    ).flow

    override suspend fun loadHeroDetail(heroId: String): List<HeroDetail> {
        return api.getHeroDetails(heroId).data.results.map {
            it.toHeroDetail()
        }
    }
}
