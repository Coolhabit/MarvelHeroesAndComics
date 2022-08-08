package ru.marvelheroes.data.entities

import ru.marvelheroes.entities.Item

data class Comics(
    val available: String,
    val collectionURI: String,
    val items: List<Item>,
    val returned: String
)