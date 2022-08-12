package ru.coolhabit.marvelheroes.ioc.modules

import android.content.Context
import dagger.Module
import dagger.Provides
import ru.marvelheroes.core.api.IDatabaseStorage
import ru.marvelheroes.data.DatabaseStorageImpl
import javax.inject.Singleton

@Module
class StoragesModule {

    @Provides
    @Singleton
    fun provideDatabase(context: Context): IDatabaseStorage = DatabaseStorageImpl(context)
}
