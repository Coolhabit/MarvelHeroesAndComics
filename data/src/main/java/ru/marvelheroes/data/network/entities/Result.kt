package ru.marvelheroes.data.network.entities

import com.google.gson.annotations.SerializedName

private const val COMICS = "comics"
private const val DESCRIPTION = "description"
private const val EVENTS = "events"
private const val ID = "id"
private const val MODIFIED = "modified"
private const val NAME = "name"
private const val RESOURCE_URI = "resourceURI"
private const val SERIES = "series"
private const val STORIES = "stories"
private const val THUMBNAIL = "thumbnail"
private const val URLS = "urls"

data class Result(
    @SerializedName(COMICS)
    val comics: Comics,
    @SerializedName(DESCRIPTION)
    val description: String,
    @SerializedName(EVENTS)
    val events: Events,
    @SerializedName(ID)
    val id: String,
    @SerializedName(MODIFIED)
    val modified: String,
    @SerializedName(NAME)
    val name: String,
    @SerializedName(RESOURCE_URI)
    val resourceURI: String,
    @SerializedName(SERIES)
    val series: Series,
    @SerializedName(STORIES)
    val stories: Stories,
    @SerializedName(THUMBNAIL)
    val thumbnail: Thumbnail,
    @SerializedName(URLS)
    val urls: List<Url>
)
