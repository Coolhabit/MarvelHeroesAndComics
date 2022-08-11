package ru.marvelheroes.data.network.entities

import com.google.gson.annotations.SerializedName

private const val AVAILABLE = "available"
private const val COLLECTION_URI = "collectionURI"
private const val ITEMS = "items"
private const val RETURNED = "returned"

data class Comics(
    @SerializedName(AVAILABLE)
    val available: String,
    @SerializedName(COLLECTION_URI)
    val collectionURI: String,
    @SerializedName(ITEMS)
    val items: List<Item>,
    @SerializedName(RETURNED)
    val returned: String
)
