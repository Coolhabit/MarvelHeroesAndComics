package ru.marvelheroes.usecases

import androidx.paging.PagingData
import kotlinx.coroutines.flow.Flow
import ru.marvelheroes.core.api.IComicsApiService
import ru.marvelheroes.core.api.IDatabaseStorage
import ru.marvelheroes.core.api.IHeroesApiService
import ru.marvelheroes.entities.dto.hero.Hero
import ru.marvelheroes.entities.dto.hero.HeroDetail
import ru.marvelheroes.entities.dto.hero.HeroDetailData
import javax.inject.Inject

class HeroesUseCase @Inject constructor(
    private val heroService: IHeroesApiService,
    private val comicsService: IComicsApiService,
    private val database: IDatabaseStorage,
) {
    fun loadHeroesList(): Flow<PagingData<Hero>> {
        return heroService.loadHeroesList()
    }

    suspend fun loadHeroDetails(heroId: String): HeroDetailData {
        val heroDetailList = heroService.loadHeroDetail(heroId)
        val seriesList = comicsService.loadDetailSeriesList(heroId)
        val comicsList = comicsService.loadDetailComicsList(heroId)
        return HeroDetailData(
            heroDetail = heroDetailList,
            seriesList = seriesList,
            comicsList = comicsList,
        )
    }

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
