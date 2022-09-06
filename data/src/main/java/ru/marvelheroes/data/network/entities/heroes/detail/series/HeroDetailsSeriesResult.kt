package ru.marvelheroes.data.network.entities.heroes.detail.series

import ru.marvelheroes.data.network.entities.Thumbnail

data class HeroDetailsSeriesResult(
    val description: String,
    val endYear: String,
    val id: String,
    val rating: String,
    val startYear: String,
    val thumbnail: Thumbnail,
    val title: String,
)