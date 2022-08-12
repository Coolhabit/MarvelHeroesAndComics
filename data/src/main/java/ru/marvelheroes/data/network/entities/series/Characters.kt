package ru.marvelheroes.data.network.entities.series

data class Characters(
    val available: String,
    val collectionURI: String,
    val items: List<Item>,
    val returned: String
)