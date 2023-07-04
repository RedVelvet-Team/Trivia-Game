package com.revelet.data.local.source

interface PreferencesDataSource {

    suspend fun setScore(score: Int)

    suspend fun getScore(): Int
}