package ru.marvelheroes.data.network.entities.comics.detail

import ru.marvelheroes.data.network.entities.Thumbnail

data class ComicDetailsResult(
    val description: String,
    val id: String,
    val images: List<Image>,
    val thumbnail: Thumbnail,
    val title: String,
)
