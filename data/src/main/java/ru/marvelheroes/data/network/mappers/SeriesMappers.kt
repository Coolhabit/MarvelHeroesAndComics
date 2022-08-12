package ru.marvelheroes.data.network.mappers

import ru.marvelheroes.data.network.entities.series.Result
import ru.marvelheroes.data.network.entities.series.Thumbnail
import ru.marvelheroes.entities.dto.comics.Comics


fun Result.toComics(): Comics {
    return Comics(
        comicsId = id,
        comicsName = title,
        comicsPoster = thumbnail.toPath()
    )
}

fun Thumbnail.toPath(): String {
    return "${path}.${extension}"
}