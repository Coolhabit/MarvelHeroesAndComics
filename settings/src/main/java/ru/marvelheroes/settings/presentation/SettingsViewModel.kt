package ru.marvelheroes.settings.presentation

import androidx.lifecycle.ViewModel
import ru.marvelheroes.usecases.SettingsUseCase
import javax.inject.Inject

class SettingsViewModel @Inject constructor(private val useCase: SettingsUseCase) : ViewModel() {

    suspend fun saveDayNightCheck(isChecked: Boolean) {
        useCase.setDayNightCheck(isChecked)
    }

    suspend fun getDayNightCheck(): Boolean {
        return useCase.getDayNightCheck()
    }
}
