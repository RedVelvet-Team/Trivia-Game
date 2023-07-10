package com.redvelvet.trivia_game.domain.repository

import com.redvelvet.trivia_game.domain.entity.Question

interface ITriviaRepository {

    /*suspend fun getQuestionsRandomly()

    suspend fun getQuestionsByLimit(
        limit: Int = 1,
        types: String = "text_choice"
    )

    suspend fun getQuestionsByLevel(
        limit: Int = 1,
        vararg difficulties: String,
        types: String = "text_choice"
    )

    suspend fun getQuestionsByCategories(
        limit: Int = 1,
        vararg category: String,
        types: String = "text_choice"
    )*/

    suspend fun getRandomSetOfQuestion (
        limit: Int? = null,
        categories: String? = null,
        difficulties: String? = null,
        types: String? = null
    ): List<Question>
}
