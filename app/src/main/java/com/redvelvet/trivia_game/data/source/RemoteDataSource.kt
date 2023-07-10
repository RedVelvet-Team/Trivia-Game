package com.redvelvet.trivia_game.data.source

import com.redvelvet.trivia_game.data.remote.dto.QuestionDto

interface RemoteDataSource {
    suspend fun getRandomSetOfQuestion(
        limit: Int?,
        categories: String?,
        difficulties: String?,
        types: String?,
    ): List<QuestionDto>
}