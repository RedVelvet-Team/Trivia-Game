package com.redvelvet.domain.usecases

import com.redvelvet.domain.repository.ITriviaRepository
import javax.inject.Inject


class StartGameUseCase @Inject constructor(
    private val gameSession: GameSession,
    private val triviaRepository: ITriviaRepository,
    private val casualModeUseCase: StartCasualGameUseCase,
    private val timedModeUseCase: StartTimedGameUseCase,
    private val survivalModeUseCase: StartSurvivalGameUseCase
) {
    suspend fun invoke(gameMode: Int) {
        gameSession.isGameOver = false
        gameSession.score = 0
        triviaRepository.saveScore(gameSession.score)

        when (gameMode) {
            1 -> casualModeUseCase.invoke()
            2 -> timedModeUseCase.invoke()
            3 -> survivalModeUseCase.invoke()
        }
    }
}
