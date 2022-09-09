package ru.marvelheroes.usecases

import ru.marvelheroes.core.ILocalStorage
import javax.inject.Inject

class SettingsUseCase @Inject constructor(private val localStorage: ILocalStorage) {

    suspend fun setDayNightCheck(isChecked: Boolean) {
        localStorage.setDayNightModeEnabled(isChecked)
    }

    suspend fun getDayNightCheck(): Boolean {
        return localStorage.getDayNightModeEnabled()
    }
}