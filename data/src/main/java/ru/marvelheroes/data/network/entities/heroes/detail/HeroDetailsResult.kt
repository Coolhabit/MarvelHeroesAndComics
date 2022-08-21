package ru.marvelheroes.data.network.entities.heroes.detail

import ru.marvelheroes.data.network.entities.Thumbnail

data class HeroDetailsResult(
    val description: String,
    val id: String,
    val name: String,
    val thumbnail: Thumbnail,
)