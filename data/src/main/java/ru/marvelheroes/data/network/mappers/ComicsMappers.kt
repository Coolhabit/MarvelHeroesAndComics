package ru.marvelheroes.data.network.mappers

import ru.marvelheroes.data.network.entities.comics.Result
import ru.marvelheroes.data.network.entities.comics.Thumbnail
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
