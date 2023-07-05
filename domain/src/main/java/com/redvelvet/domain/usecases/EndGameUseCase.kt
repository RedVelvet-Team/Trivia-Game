package com.redvelvet.domain.usecases

import com.redvelvet.domain.repository.ITriviaRepository
import javax.inject.Inject

class EndGameUseCase @Inject constructor(
    private val gameSession: GameSession,
    private val triviaRepository: ITriviaRepository,
) {
    suspend fun invoke() {
        if (gameSession.score >= 5) {
            triviaRepository.saveScore(getCurrentScore() + gameSession.score)
        }
    }

    private suspend fun getCurrentScore(): Int {
        return triviaRepository.getScore()
    }
}
