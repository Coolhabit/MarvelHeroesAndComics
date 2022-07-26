package ru.coolhabit.marvelheroes.ioc.modules

import dagger.Module
import dagger.android.ContributesAndroidInjector
import ru.coolhabit.marvelheroes.heroes.presentation.HeroFragment

@Module(includes = [ViewModelModule::class, ActivityModule::class])
abstract class FragmentsModule {

    @ContributesAndroidInjector
    abstract fun provideHeroesFragment(): HeroFragment
}
