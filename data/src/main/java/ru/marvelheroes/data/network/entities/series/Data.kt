package ru.marvelheroes.data.network.entities.series

data class Data(
    val count: String,
    val limit: String,
    val offset: String,
    val results: List<SeriesResult>,
    val total: String
)