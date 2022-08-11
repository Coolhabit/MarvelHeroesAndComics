package ru.marvelheroes.data.network.mappers

import ru.marvelheroes.data.network.entities.heroes.Result
import ru.marvelheroes.data.network.entities.heroes.Thumbnail
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
