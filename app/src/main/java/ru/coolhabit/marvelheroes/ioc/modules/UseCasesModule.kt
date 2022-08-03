package ru.coolhabit.marvelheroes.ioc.modules

import dagger.Module
import dagger.Provides
import ru.marvelheroes.core.api.IHeroesApiService
import ru.marvelheroes.usecases.HeroesUseCase
import javax.inject.Singleton

@Module
class UseCasesModule {

    @Provides
    @Singleton
    fun provideHeroesUseCase(
        api: IHeroesApiService,
    ) = HeroesUseCase(api)
}
