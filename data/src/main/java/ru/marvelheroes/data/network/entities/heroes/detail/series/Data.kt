package ru.marvelheroes.data.network.entities.heroes.detail.series

data class Data(
    val count: String,
    val limit: String,
    val offset: String,
    val results: List<HeroDetailsSeriesResult>,
    val total: String
)