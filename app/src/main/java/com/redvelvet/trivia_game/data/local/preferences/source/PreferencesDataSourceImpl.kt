package com.redvelvet.trivia_game.data.local.preferences.source

import com.redvelvet.trivia_game.data.local.preferences.store.PreferencesDataStore
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