package ru.coolhabit.marvelheroes.ioc.modules

import dagger.Module
import dagger.Provides
import ru.marvelheroes.core.api.IHeroesApiService
import ru.marvelheroes.core.api.MarvelApi
import ru.marvelheroes.data.MarvelHeroesService
import ru.marvelheroes.data.mock.MockApiService
import javax.inject.Singleton

@Module
class ApiModule {

    @Provides
    @Singleton
    fun provideHeroesApi(api: MarvelApi): IHeroesApiService = MarvelHeroesService(api)
}
