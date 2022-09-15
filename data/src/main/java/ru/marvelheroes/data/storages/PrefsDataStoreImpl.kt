package ru.marvelheroes.data.storages

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.booleanPreferencesKey
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.preferencesDataStore
import kotlinx.coroutines.flow.first
import ru.marvelheroes.core.ILocalStorage

class PrefsDataStoreImpl(private val context: Context) : ILocalStorage {

    private val Context.dataStore: DataStore<Preferences> by preferencesDataStore(DATASTORE_NAME)

    companion object {
        private const val DATASTORE_NAME = "pref_file"
        val PREF_DAY_NIGHT_MODE = booleanPreferencesKey("marvelhc:daynight")
    }

    override suspend fun setDayNightModeEnabled(enabled: Boolean) {
        context.dataStore.edit {
            it[PREF_DAY_NIGHT_MODE] = enabled
        }
    }

    override suspend fun getDayNightModeEnabled(): Boolean {
        val preferences = context.dataStore.data.first()
        return preferences[PREF_DAY_NIGHT_MODE] ?: false
    }

    override suspend fun clearOnLogout(): Boolean {
        context.dataStore.edit {
            it.clear()
        }
        return true
    }

    private suspend fun getPrefs() = context.dataStore.data.first()
}
