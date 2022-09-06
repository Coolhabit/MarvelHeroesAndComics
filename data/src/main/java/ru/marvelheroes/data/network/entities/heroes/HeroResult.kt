package ru.marvelheroes.data.network.entities.heroes

import com.google.gson.annotations.SerializedName
import ru.marvelheroes.data.network.entities.Thumbnail

private const val DESCRIPTION = "description"
private const val ID = "id"
private const val NAME = "name"
private const val THUMBNAIL = "thumbnail"

data class HeroResult(
    @SerializedName(DESCRIPTION)
    val description: String,
    @SerializedName(ID)
    val id: String,
    @SerializedName(NAME)
    val name: String,
    @SerializedName(THUMBNAIL)
    val thumbnail: Thumbnail,
)
