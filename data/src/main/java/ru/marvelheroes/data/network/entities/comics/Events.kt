package ru.marvelheroes.data.network.entities.comics

data class Events(
    val available: String,
    val collectionURI: String,
    val items: List<ItemXX>,
    val returned: String
)