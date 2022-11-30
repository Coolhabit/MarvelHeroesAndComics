package ru.coolhabit.marvelheroes.ioc

import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule
import ru.coolhabit.marvelheroes.MarvelApp
import ru.coolhabit.marvelheroes.ioc.modules.ActivityModule
import ru.coolhabit.marvelheroes.ioc.modules.ApiModule
import ru.coolhabit.marvelheroes.ioc.modules.ApplicationModule
import ru.coolhabit.marvelheroes.ioc.modules.FragmentsModule
import ru.coolhabit.marvelheroes.ioc.modules.NavigationRoutersModule
import ru.coolhabit.marvelheroes.ioc.modules.StoragesModule
import ru.coolhabit.marvelheroes.ioc.modules.UseCasesModule
import ru.coolhabit.marvelheroes.ioc.modules.ViewModelModule
import ru.marvelheroes.data.ioc.RemoteModule
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        AndroidSupportInjectionModule::class,
        ViewModelModule::class,
        ActivityModule::class,
        ApplicationModule::class,
        FragmentsModule::class,
        UseCasesModule::class,
        NavigationRoutersModule::class,
        ApiModule::class,
        RemoteModule::class,
        StoragesModule::class,
    ]
)
interface ApplicationComponent : AndroidInjector<MarvelApp> {

    @Component.Factory
    interface Factory {
        fun create(@BindsInstance applicationContext: MarvelApp): ApplicationComponent
    }
}
