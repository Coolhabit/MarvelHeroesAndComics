package ru.coolhabit.marvelheroes.ioc.modules

import dagger.Module
import dagger.Provides
import ru.marvelheroes.core.api.IHeroesApiService
import ru.marvelheroes.data.network.HeroesPagingSource
import ru.marvelheroes.data.network.services.MarvelHeroesService
import javax.inject.Singleton

@Module
class ApiModule {

    @Provides
    @Singleton
    fun provideHeroesApi(pagingFactory: HeroesPagingSource.Factory): IHeroesApiService = MarvelHeroesService(pagingFactory)
}
