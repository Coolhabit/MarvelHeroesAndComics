package ru.coolhabit.marvelheroes.ioc.modules

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap
import ru.coolhabit.marvelheroes.heroes.presentation.HeroesViewModel
import ru.coolhabit.marvelheroes.ioc.utils.ViewModelFactory
import ru.coolhabit.marvelheroes.ioc.utils.ViewModelKey
import ru.coolhabit.marvelheroes.presentation.MainActivityViewModel

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
}