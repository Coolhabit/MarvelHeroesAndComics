package ru.marvelheroes.data.entities

import ru.marvelheroes.entities.Comics
import ru.marvelheroes.entities.Events
import ru.marvelheroes.entities.Series
import ru.marvelheroes.entities.Stories
import ru.marvelheroes.entities.Thumbnail
import ru.marvelheroes.entities.Url

data class Result(
    val comics: Comics,
    val description: String,
    val events: Events,
    val id: String,
    val modified: String,
    val name: String,
    val resourceURI: String,
    val series: Series,
    val stories: Stories,
    val thumbnail: Thumbnail,
    val urls: List<Url>
)