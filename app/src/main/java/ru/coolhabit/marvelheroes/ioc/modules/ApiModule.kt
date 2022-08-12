package ru.coolhabit.marvelheroes.ioc.modules

import dagger.Module
import dagger.Provides
import ru.marvelheroes.core.api.IComicsApiService
import ru.marvelheroes.core.api.IHeroesApiService
import ru.marvelheroes.data.db.dao.HeroesDao
import ru.marvelheroes.data.network.paging.ComicsPagingSource
import ru.marvelheroes.data.network.paging.HeroesPagingSource
import ru.marvelheroes.data.network.services.MarvelComicsService
import ru.marvelheroes.data.network.services.MarvelHeroesService
import javax.inject.Singleton

@Module
class ApiModule {

    @Provides
    @Singleton
    fun provideHeroesApi(pagingFactory: HeroesPagingSource.Factory): IHeroesApiService = MarvelHeroesService(pagingFactory)

    @Provides
    @Singleton
    fun provideComicsApi(pagingFactory: ComicsPagingSource.Factory): IComicsApiService = MarvelComicsService(pagingFactory)
}
