package ru.marvelheroes.data.db

import androidx.room.Database
import androidx.room.RoomDatabase
import ru.marvelheroes.data.db.AppDatabase.Companion.DATABASE_VERSION
import ru.marvelheroes.data.db.dao.HeroesDao
import ru.marvelheroes.data.db.entities.HeroDB

@Database(entities = [HeroDB::class], version = DATABASE_VERSION, exportSchema = false)
abstract class AppDatabase : RoomDatabase() {

    abstract fun heroesDao(): HeroesDao

    companion object {
        const val DATABASE_NAME = "marvelhc_db"
        const val DATABASE_VERSION = 1
    }
}
