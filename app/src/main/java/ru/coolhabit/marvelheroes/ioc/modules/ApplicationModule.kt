package ru.coolhabit.marvelheroes.ioc.modules

import android.content.Context
import dagger.Module
import dagger.Provides
import ru.coolhabit.marvelheroes.MarvelApp

@Module
class ApplicationModule {

    @Provides
    fun provideContext(app: MarvelApp): Context = app.applicationContext
}
