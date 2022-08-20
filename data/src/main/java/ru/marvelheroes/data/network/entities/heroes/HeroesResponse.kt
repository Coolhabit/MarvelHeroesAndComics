package ru.marvelheroes.data.network.entities.heroes

import com.google.gson.annotations.SerializedName

private const val DATA = "data"

data class HeroesResponse(
    @SerializedName(DATA)
    val data: Data,
)
