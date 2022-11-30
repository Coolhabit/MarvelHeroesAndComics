package ru.marvelheroes.data.network.entities.comics.detail

data class Data(
    val count: String,
    val limit: String,
    val offset: String,
    val results: List<ComicDetailsResult>,
    val total: String
)
