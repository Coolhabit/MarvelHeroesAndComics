package ru.marvelheroes.data.db.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import ru.marvelheroes.data.db.AppDatabase.Companion.DATABASE_NAME
import ru.marvelheroes.entities.dto.hero.Hero

@Entity(tableName = DATABASE_NAME)
data class HeroDB(
    @PrimaryKey
    @ColumnInfo(name = "dbHeroId") val dbHeroId: String,
    @ColumnInfo(name = "dbHeroName") val dbHeroName: String,
    @ColumnInfo(name = "dbHeroPoster") val dbHeroPoster: String,
)

fun Hero.toData() = HeroDB(
    dbHeroId = heroId,
    dbHeroName = heroName,
    dbHeroPoster = heroPoster
)

fun HeroDB.toDomain() = Hero(
    heroId = dbHeroId,
    heroName = dbHeroName,
    heroPoster = dbHeroPoster,
)
