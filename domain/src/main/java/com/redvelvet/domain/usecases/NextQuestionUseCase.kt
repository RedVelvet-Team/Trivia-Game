package com.redvelvet.domain.usecases

import com.redvelvet.domain.entity.Question
import javax.inject.Inject

class NextQuestionUseCase @Inject constructor(
    getCustomizedQuestionsUsecase: GetCustomizedQuestionsUsecase,
    private val endGameUseCase: EndGameUseCase,
    private val timedModeUseCase: TimedModeUseCase
) {
    private var questionIndex = getCustomizedQuestionsUsecase.questionIndex
    private var questions: List<Question> = getCustomizedQuestionsUsecase.questions

    suspend fun invoke(): Question {
        return if (questionIndex < questions.size) {
            questions[questionIndex++]
        } else {
            finishGame()
            questions[questionIndex]
        }
    }

    private suspend fun finishGame() {
        timedModeUseCase.stopTimer()
        endGameUseCase.invoke()
    }
}

