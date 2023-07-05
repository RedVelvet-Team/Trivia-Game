package com.redvelvet.domain.usecases

import com.redvelvet.domain.entity.QuestionEntity
import com.redvelvet.domain.utils.TriviaException

class NextQuestionUseCase(private val getCustomizedQuestionsUsecase: GetCustomizedQuestionsUsecase) {
    suspend fun invoke(parameters: Unit): QuestionEntity {
        return getCustomizedQuestionsUsecase.getNextQuestion()
            ?: throw TriviaException.NoMoreQuestionsException()
    }
}

