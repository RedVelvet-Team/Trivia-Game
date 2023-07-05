package com.redvelvet.domain.usecases

import com.redvelvet.domain.repository.ITriviaRepository
import javax.inject.Inject

class GetCustomizedQuestions @Inject constructor(
    private val triviaRepository: ITriviaRepository
) {
    suspend operator fun invoke(
        limit: Int = 10,
        categories: List<String>,
        difficulties: List<String>,
        types: String = "text_choice"
    ) {
        triviaRepository.getRandomSetOfQuestion(
            limit, categories.toCommaSeparatedString(), difficulties.toCommaSeparatedString(), types
        )
    }

    private fun List<String>.toCommaSeparatedString(): String {
        return joinToString(", ")
    }

}










