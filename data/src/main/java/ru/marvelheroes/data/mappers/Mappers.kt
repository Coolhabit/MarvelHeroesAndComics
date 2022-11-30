package ru.marvelheroes.data.mappers

import ru.marvelheroes.data.network.entities.Thumbnail
import ru.marvelheroes.data.network.entities.comics.detail.ComicDetailsResult
import ru.marvelheroes.data.network.entities.comics.detail.Image
import ru.marvelheroes.data.network.entities.heroes.HeroResult
import ru.marvelheroes.data.network.entities.heroes.detail.HeroDetailsResult
import ru.marvelheroes.data.network.entities.heroes.detail.comics.HeroDetailsComicsResult
import ru.marvelheroes.data.network.entities.heroes.detail.series.HeroDetailsSeriesResult
import ru.marvelheroes.data.network.entities.series.SeriesResult
import ru.marvelheroes.entities.dto.books.Comics
import ru.marvelheroes.entities.dto.comics.ComicDetail
import ru.marvelheroes.entities.dto.comics.ComicImage
import ru.marvelheroes.entities.dto.books.Series
import ru.marvelheroes.entities.dto.hero.Hero
import ru.marvelheroes.entities.dto.hero.HeroDetail

fun Thumbnail.toPath(): String {
    return "${path}.${extension}"
}

fun Image.toComicImage(): ComicImage {
    return ComicImage(
        path = "${path}.${extension}"
    )
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

fun HeroDetailsResult.toHeroDetail(): HeroDetail {
    return HeroDetail(
        hero = Hero(
            heroId = id,
            heroName = name,
            heroPoster = thumbnail.toPath()
        ),
        description = description,
    )
}

fun HeroDetailsSeriesResult.toHeroDetailSeries(): Series {
    return Series(
        seriesId = id,
        seriesName = title,
        seriesPoster = thumbnail.toPath()
    )
}

fun HeroDetailsComicsResult.toHeroDetailComics(): Comics {
    return Comics(
        comicsId = id,
        comicsName = title,
        comicsPoster = thumbnail.toPath()
    )
}

fun ComicDetailsResult.toComicDetails(): ComicDetail {
    return ComicDetail(
        comicId = id,
        comicDescription = description,
        comicName = title,
        comicPoster = thumbnail.toPath(),
        comicImages = images.map {
            it.toComicImage()
        }
    )
}
