package ru.marvelheroes.entities

import ru.marvelheroes.entities.ItemXXX

data class Stories(
    val available: String,
    val collectionURI: String,
    val items: List<ItemXXX>,
    val returned: String
)