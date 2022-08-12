package ru.marvelheroes.data.network.entities.series

data class SeriesResponse(
    val attributionHTML: String,
    val attributionText: String,
    val code: String,
    val copyright: String,
    val data: Data,
    val etag: String,
    val status: String
)