package ru.marvelheroes.data.network

import ru.marvelheroes.data.network.entities.Result
import ru.marvelheroes.data.network.entities.Thumbnail
import ru.marvelheroes.entities.dto.hero.Hero

fun Result.toHero(): Hero {
    return Hero(
        heroId = id,
        heroName = name,
        heroPoster = thumbnail.toPath()
    )
}

fun Thumbnail.toPath(): String {
    return "${path}.${extension}"
}