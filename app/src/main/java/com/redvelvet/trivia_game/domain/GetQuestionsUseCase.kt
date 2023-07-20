package com.redvelvet.trivia_game.domain

import com.redvelvet.trivia_game.domain.entity.Question
import com.redvelvet.trivia_game.domain.repository.ITriviaRepository
import javax.inject.Inject

class GetQuestionsUseCase @Inject constructor (
    private val iTriviaRepository: ITriviaRepository
) {
    suspend operator fun invoke(categories: String,difficulties : String): List<Question> {
        return iTriviaRepository.getRandomSetOfQuestion(
            limit = 10,
            categories = categories,
            difficulties = difficulties
        )
    }
}