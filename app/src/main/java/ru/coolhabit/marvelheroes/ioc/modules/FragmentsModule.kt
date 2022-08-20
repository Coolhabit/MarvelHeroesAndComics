package ru.coolhabit.marvelheroes.ioc.modules

import dagger.Module
import dagger.android.ContributesAndroidInjector
import ru.coolhabit.marvelheroes.heroes.presentation.base.HeroesFragment
import ru.coolhabit.marvelheroes.heroes.presentation.detail.HeroDetailsFragment
import ru.marvelheroes.comics.presentation.ComicsFragment
import ru.marvelheroes.myavengers.presentation.MyAvengersFragment
import ru.marvelheroes.settings.presentation.SettingsFragment

@Module(includes = [ViewModelModule::class, ActivityModule::class])
abstract class FragmentsModule {

    @ContributesAndroidInjector
    abstract fun provideHeroesFragment(): HeroesFragment

    @ContributesAndroidInjector
    abstract fun provideComicsFragment(): ComicsFragment

    @ContributesAndroidInjector
    abstract fun provideMyAvengersFragment(): MyAvengersFragment

    @ContributesAndroidInjector
    abstract fun provideSettingsFragment(): SettingsFragment

    @ContributesAndroidInjector
    abstract fun provideHeroDetailsFragment(): HeroDetailsFragment
}
