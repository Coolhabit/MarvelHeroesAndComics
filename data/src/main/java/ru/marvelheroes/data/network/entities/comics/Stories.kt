package ru.marvelheroes.data.network.entities.comics

data class Stories(
    val available: String,
    val collectionURI: String,
    val items: List<ItemXXX>,
    val returned: String
)