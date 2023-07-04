package com.redvelvet.data.local

import com.redvelvet.data.local.preferences.PreferencesDataStore
import javax.inject.Inject

class PreferencesDataSourceImpl @Inject constructor(
    private val preferencesDataStore: PreferencesDataStore
) : PreferencesDataSource {
    override suspend fun setScore(score: Int) {
        preferencesDataStore.setScore(score)
    }

    override suspend fun getScore(): Int {
        return preferencesDataStore.getScore()
    }
}