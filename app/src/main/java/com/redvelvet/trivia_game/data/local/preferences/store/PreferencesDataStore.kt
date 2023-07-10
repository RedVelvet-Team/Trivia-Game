package com.redvelvet.trivia_game.data.local.preferences.store

interface PreferencesDataStore {

    suspend fun setScore(score: Int)

    suspend fun getScore(): Int
}