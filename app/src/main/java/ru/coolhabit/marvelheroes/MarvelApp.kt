package ru.coolhabit.marvelheroes

import dagger.android.AndroidInjector
import dagger.android.DaggerApplication
import ru.coolhabit.marvelheroes.ioc.DaggerApplicationComponent

class MarvelApp : DaggerApplication() {
    override fun applicationInjector(): AndroidInjector<out DaggerApplication> {
        return DaggerApplicationComponent
            .factory()
            .create(this)
    }
}