package ru.marvelheroes.data.network.entities.heroes.detail.comics

import ru.marvelheroes.data.network.entities.Thumbnail

data class HeroDetailsComicsResult(
    val description: String,
    val id: String,
    val thumbnail: Thumbnail,
    val title: String,
)