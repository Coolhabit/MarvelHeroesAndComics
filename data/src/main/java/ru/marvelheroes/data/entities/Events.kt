package ru.marvelheroes.data.entities

import ru.marvelheroes.entities.Item

data class Events(
    val available: String,
    val collectionURI: String,
    val items: List<Item>,
    val returned: String
)