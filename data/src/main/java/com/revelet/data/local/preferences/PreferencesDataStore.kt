package com.revelet.data.local.preferences

interface PreferencesDataStore {

    suspend fun setScore(score: Int)

    suspend fun getScore(): Int
}