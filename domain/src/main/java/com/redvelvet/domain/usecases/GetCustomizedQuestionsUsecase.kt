package com.redvelvet.domain.usecases

import com.redvelvet.domain.entity.QuestionEntity
import com.redvelvet.domain.repository.ITriviaRepository
import javax.inject.Inject

class GetCustomizedQuestionsUsecase @Inject constructor(
    private val triviaRepository: ITriviaRepository
) {

    private var questionIndex = 0
    private var questions: List<QuestionEntity> = listOf()

    suspend operator fun invoke(
        limit: Int = 10,
        categories: List<String>,
        difficulties: List<String>,
        types: String = "text_choice"
    ): List<QuestionEntity> {
        questions = triviaRepository.getRandomSetOfQuestion(
            limit, categories.toCommaSeparatedString(), difficulties.toCommaSeparatedString(), types
        )
        questionIndex = 0
        return questions
    }

    fun getNextQuestion(): QuestionEntity? {
        return if (questionIndex < questions.size) {
            questions[questionIndex++]
        } else {
            null
        }
    }

    private fun List<String>.toCommaSeparatedString(): String {
        return joinToString(", ")
    }

}










