package ru.marvelheroes.data.network.entities.heroes

data class Data(
    val offset: String,
    val limit: String,
    val total: String,
    val count: String,
    val results: List<HeroResult>,
)