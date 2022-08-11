package ru.marvelheroes.data.network.entities.comics

data class Data(
    val count: String,
    val limit: String,
    val offset: String,
    val results: List<Result>,
    val total: String
)