package ru.marvelheroes.data.entities

import ru.marvelheroes.entities.Result

data class Data(
    val offset: String,
    val limit: String,
    val total: String,
    val count: String,
    val results: List<Result>,
)