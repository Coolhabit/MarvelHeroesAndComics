package ru.marvelheroes.data

import android.content.Context
import androidx.room.Room
import ru.marvelheroes.core.api.IDatabaseStorage
import ru.marvelheroes.data.db.AppDatabase
import ru.marvelheroes.data.db.entities.toData
import ru.marvelheroes.data.db.entities.toDomain
import ru.marvelheroes.entities.dto.hero.Hero

class DatabaseStorageImpl(context: Context) : IDatabaseStorage {

    private val database: AppDatabase =
        Room
            .databaseBuilder(context, AppDatabase::class.java, AppDatabase.DATABASE_NAME)
            .fallbackToDestructiveMigration().build()

    override suspend fun addHeroToFavourite(hero: Hero) {
        database.heroesDao().insert(hero.toData())
    }

    override suspend fun removeHeroFromFavourite(hero: Hero) {
        database.heroesDao().delete(hero.toData())
    }

    override suspend fun getFavouriteHeroes(): List<Hero> {
        return database.heroesDao().getFavouriteHeroes().map { it.toDomain() }
    }
}
