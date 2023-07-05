package com.redvelvet.domain.usecases

import com.redvelvet.domain.entity.Configurations
import com.redvelvet.domain.entity.Question
import com.redvelvet.domain.repository.ITriviaRepository
import javax.inject.Inject

class GetCustomizedQuestionsUsecase @Inject constructor(
    private val triviaRepository: ITriviaRepository
) {

    var questionIndex = 0
    var questions: List<Question> = listOf()
    suspend fun invoke(
        configurations: Configurations
    ) {
        questions = triviaRepository.getRandomSetOfQuestion(
            configurations.limit,
            configurations.categories.toCommaSeparatedString(),
            configurations.difficulties.toCommaSeparatedString(),
            configurations.types
        )
        questionIndex = 0
    }

    private fun List<String>.toCommaSeparatedString(): String {
        return joinToString(", ")
    }

}










