package ru.marvelheroes.data.network.mappers

import ru.marvelheroes.data.network.entities.Thumbnail
import ru.marvelheroes.data.network.entities.heroes.HeroResult
import ru.marvelheroes.data.network.entities.series.SeriesResult
import ru.marvelheroes.entities.dto.series.Series
import ru.marvelheroes.entities.dto.hero.Hero

fun Thumbnail.toPath(): String {
    return "${path}.${extension}"
}

fun HeroResult.toHero(): Hero {
    return Hero(
        heroId = id,
        heroName = name,
        heroPoster = thumbnail.toPath()
    )
}

fun SeriesResult.toSeries(): Series {
    return Series(
        seriesId = id,
        seriesName = title,
        seriesPoster = thumbnail.toPath()
    )
}

