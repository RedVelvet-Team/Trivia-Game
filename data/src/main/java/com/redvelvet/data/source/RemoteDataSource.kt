package com.redvelvet.data.source

import com.redvelvet.data.remote.dto.QuestionDto

interface RemoteDataSource {
    suspend fun getRandomSetOfQuestion(
        limit: Int,
        categories: String,
        difficulties: String,
        types: String,
    ): List<QuestionDto>
}