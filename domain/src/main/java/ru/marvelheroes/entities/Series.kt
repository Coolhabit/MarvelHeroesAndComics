package ru.marvelheroes.entities

import ru.marvelheroes.entities.Item

data class Series(
    val available: String,
    val collectionURI: String,
    val items: List<Item>,
    val returned: String
)