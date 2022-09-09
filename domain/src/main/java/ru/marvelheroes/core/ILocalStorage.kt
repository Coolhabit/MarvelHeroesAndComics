package ru.marvelheroes.core

interface ILocalStorage {

    suspend fun clearOnLogout(): Boolean

    suspend fun setDayNightModeEnabled(enabled: Boolean)

    suspend fun getDayNightModeEnabled(): Boolean
}