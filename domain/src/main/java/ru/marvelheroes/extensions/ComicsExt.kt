package ru.marvelheroes.extensions

import ru.marvelheroes.entities.dto.books.Comics
import ru.marvelheroes.entities.dto.comics.ComicDetail

fun ComicDetail.toComics(): Comics {
    return Comics(
        comicsId = comicId,
        comicsName = comicName,
        comicsPoster = comicPoster
    )
}
