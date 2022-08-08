package ru.marvelheroes.data.entities

import com.google.gson.annotations.SerializedName
import ru.marvelheroes.entities.Data

private const val CODE = "code"
private const val STATUS = "status"
private const val DATA = "data"
private const val ETAG = "etag"
private const val COPYRIGHT = "copyright"
private const val ATTR_TEXT = "attributionText"
private const val ATTR_HTML = "attributionHTML"

data class MarvelApiResponse(
    @SerializedName(CODE)
    val code: String,
    @SerializedName(STATUS)
    val status: String,
    @SerializedName(DATA)
    val data: Data,
    @SerializedName(ETAG)
    val etag: String,
    @SerializedName(COPYRIGHT)
    val copyright: String,
    @SerializedName(ATTR_TEXT)
    val attributionText: String,
    @SerializedName(ATTR_HTML)
    val attributionHTML: String,
)
