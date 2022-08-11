package ru.marvelheroes.data.network.entities

import com.google.gson.annotations.SerializedName

private const val PATH = "path"
private const val EXTENSION = "extension"

data class Thumbnail(
    @SerializedName(EXTENSION)
    val extension: String,
    @SerializedName(PATH)
    val path: String
)
