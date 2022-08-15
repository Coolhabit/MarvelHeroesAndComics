package ru.marvelheroes.data.network.entities.series

data class Events(
    val available: String,
    val collectionURI: String,
    val items: List<ItemXXXX>,
    val returned: String
)