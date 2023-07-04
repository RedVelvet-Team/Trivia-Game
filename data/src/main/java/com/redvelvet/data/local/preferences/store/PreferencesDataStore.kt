package com.redvelvet.data.local.preferences.store

interface PreferencesDataStore {

    suspend fun setScore(score: Int)

    suspend fun getScore(): Int
}