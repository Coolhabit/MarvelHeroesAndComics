package ru.coolhabit.marvelheroes.ioc.modules

import dagger.Module
import dagger.android.ContributesAndroidInjector
import ru.coolhabit.marvelheroes.presentation.MainActivity

@Module(includes = [ViewModelModule::class])
abstract class ActivityModule {

    @ContributesAndroidInjector()
    abstract fun mainActivity(): MainActivity
}