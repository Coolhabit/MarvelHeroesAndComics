package ru.marvelheroes.data.db.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import kotlinx.coroutines.flow.Flow
import ru.marvelheroes.data.db.AppDatabase.Companion.DATABASE_NAME
import ru.marvelheroes.data.db.entities.HeroDB

@Dao
interface HeroesDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(hero: HeroDB)

    @Delete
    suspend fun delete(hero: HeroDB)

    @Query("SELECT * FROM $DATABASE_NAME")
    fun getFavouriteHeroes(): Flow<List<HeroDB>>
}
