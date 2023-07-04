package com.redvelvet.data.local

interface PreferencesDataSource {

    suspend fun setScore(score: Int)

    suspend fun getScore(): Int
}