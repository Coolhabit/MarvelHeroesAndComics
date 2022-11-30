package ru.marvelheroes.data.network.entities.series

import ru.marvelheroes.data.network.entities.Thumbnail

data class SeriesResult(
    val description: String,
    val id: String,
    val rating: String,
    val thumbnail: Thumbnail,
    val title: String,
)