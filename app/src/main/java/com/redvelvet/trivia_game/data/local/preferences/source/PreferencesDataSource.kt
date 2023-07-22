package com.redvelvet.trivia_game.data.local.preferences.source

interface PreferencesDataSource {

    suspend fun setScore(score: Int)

    suspend fun getScore(): Int
}