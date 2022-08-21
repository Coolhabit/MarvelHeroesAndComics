package ru.marvelheroes.data.network.entities.heroes.detail.comics

data class Data(
    val count: String,
    val limit: String,
    val offset: String,
    val results: List<HeroDetailsComicsResult>,
    val total: String
)