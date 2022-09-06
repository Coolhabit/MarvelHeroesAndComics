package ru.coolhabit.marvelheroes.ioc.modules

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap
import ru.coolhabit.marvelheroes.heroes.presentation.base.HeroesViewModel
import ru.marvelheroes.herodetails.HeroDetailsViewModel
import ru.coolhabit.marvelheroes.ioc.utils.ViewModelFactory
import ru.coolhabit.marvelheroes.ioc.utils.ViewModelKey
import ru.coolhabit.marvelheroes.presentation.MainActivityViewModel
import ru.marvelheroes.comics.presentation.ComicsViewModel
import ru.marvelheroes.myavengers.presentation.MyAvengersViewModel
import ru.marvelheroes.settings.presentation.SettingsViewModel

@Module
abstract class ViewModelModule {

    @Binds
    abstract fun bindViewModelFactory(factory: ViewModelFactory): ViewModelProvider.Factory

    @Binds
    @IntoMap
    @ViewModelKey(MainActivityViewModel::class)
    abstract fun mainActivityViewModel(viewModel: MainActivityViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(HeroesViewModel::class)
    abstract fun heroesViewModel(viewModel: HeroesViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(ComicsViewModel::class)
    abstract fun comicsViewModel(viewModel: ComicsViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(MyAvengersViewModel::class)
    abstract fun myAvengersViewModel(viewModel: MyAvengersViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(SettingsViewModel::class)
    abstract fun settingsViewModel(viewModel: SettingsViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(HeroDetailsViewModel::class)
    abstract fun heroDetailsViewModel(viewModel: HeroDetailsViewModel): ViewModel
}
