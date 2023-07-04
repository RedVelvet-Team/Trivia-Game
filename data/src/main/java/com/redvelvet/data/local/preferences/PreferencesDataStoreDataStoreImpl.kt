package com.redvelvet.data.local.preferences

import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.intPreferencesKey
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class PreferencesDataStoreDataStoreImpl @Inject constructor(
    private val dataStore: DataStore<Preferences>
) : PreferencesDataStore {
    override suspend fun setScore(score: Int) {
        dataStore.edit { preferences ->
            preferences[intPreferencesKey(SCORE)] = score

        }
    }

    override suspend fun getScore(): Int {
        return dataStore.data.map { preferences ->
            preferences[intPreferencesKey(SCORE)] ?: 0
        }.first()
    }

    private companion object {
        const val SCORE = "score"
    }
}