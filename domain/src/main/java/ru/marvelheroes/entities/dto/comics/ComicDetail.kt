package ru.marvelheroes.entities.dto.comics

data class ComicDetail(
    val comicId: String,
    val comicName: String,
    val comicDescription: String,
    val comicPoster: String,
    val comicImages: List<ComicImage>
)
