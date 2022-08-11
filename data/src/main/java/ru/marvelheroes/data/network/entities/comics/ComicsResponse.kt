package ru.marvelheroes.data.network.entities.comics

data class ComicsResponse(
    val attributionHTML: String,
    val attributionText: String,
    val code: String,
    val copyright: String,
    val data: Data,
    val etag: String,
    val status: String
)