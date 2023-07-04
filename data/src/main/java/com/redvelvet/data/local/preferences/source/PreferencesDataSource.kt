package com.redvelvet.data.local.preferences.source

interface PreferencesDataSource {

    suspend fun setScore(score: Int)

    suspend fun getScore(): Int
}