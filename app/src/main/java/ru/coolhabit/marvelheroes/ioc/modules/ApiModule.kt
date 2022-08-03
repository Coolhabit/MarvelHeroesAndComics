package ru.coolhabit.marvelheroes.ioc.modules

import dagger.Module
import dagger.Provides
import ru.marvelheroes.core.api.IHeroesApiService
import ru.marvelheroes.data.mock.MockApiService
import javax.inject.Singleton

@Module
class ApiModule {

    @Provides
    @Singleton
    fun provideHeroesApi(): IHeroesApiService = MockApiService()
}
