package com.redvelvet.domain.usecases

import javax.inject.Inject

class CheckAnswerUseCase @Inject constructor(
    private val gameSession: GameSession
) {
    fun invoke(answer: String): Boolean {
        return answer == gameSession.currentQuestion?.correctAnswer
    }
}
