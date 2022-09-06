package ru.coolhabit.marvelheroes.ioc.modules

import dagger.Module
import dagger.Provides
import ru.marvelheroes.core.api.IComicsApiService
import ru.marvelheroes.core.api.IDatabaseStorage
import ru.marvelheroes.core.api.IHeroesApiService
import ru.marvelheroes.usecases.ComicsUseCase
import ru.marvelheroes.usecases.HeroesUseCase
import ru.marvelheroes.usecases.MyAvengersUseCase
import javax.inject.Singleton

@Module
class UseCasesModule {

    @Provides
    @Singleton
    fun provideHeroesUseCase(
        heroApi: IHeroesApiService,
        comicsApi: IComicsApiService,
        database: IDatabaseStorage,
    ) = HeroesUseCase(heroApi, comicsApi, database)

    @Provides
    @Singleton
    fun provideComicsUseCase(
        api: IComicsApiService,
    ) = ComicsUseCase(api)

    @Provides
    @Singleton
    fun provideAvengersUseCase(
        database: IDatabaseStorage,
    ) = MyAvengersUseCase(database)
}
