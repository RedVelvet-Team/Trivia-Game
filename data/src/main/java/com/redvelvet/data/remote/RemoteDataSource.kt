package com.redvelvet.data.remote

import com.redvelvet.data.remote.dto.QuestionDto

interface RemoteDataSource {

    suspend fun getQuestionById(id: String): QuestionDto

    suspend fun getRandomSetOfQuestion(
        limit: Int,
        categories: String,
        difficulties: String,
        types: String,
    ): QuestionDto
}