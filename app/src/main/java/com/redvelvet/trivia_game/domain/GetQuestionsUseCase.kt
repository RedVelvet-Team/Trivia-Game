package com.redvelvet.trivia_game.domain

import com.redvelvet.trivia_game.domain.entity.Question
import com.redvelvet.trivia_game.domain.repository.ITriviaRepository
import com.redvelvet.trivia_game.domain.utils.TriviaException
import javax.inject.Inject

class GetQuestionsUseCase @Inject constructor (
    private val iTriviaRepository: ITriviaRepository
) {
    suspend operator fun invoke(categories: String,difficulties : String): List<Question> {
        return try {
            iTriviaRepository.getRandomSetOfQuestion(
                limit = 10,
                categories = categories,
                difficulties = difficulties,
                types = "text_choice"
            )
        }catch (e: TriviaException){
            throw e
        }
    }
}