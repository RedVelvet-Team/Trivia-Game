package com.redvelvet.domain.usecases

import com.redvelvet.domain.repository.ITriviaRepository
import com.redvelvet.domain.utils.GameMode
import javax.inject.Inject


class StartGameUseCase @Inject constructor(
    private val gameSession: GameSession,
    private val triviaRepository: ITriviaRepository,
    private val casualModeUseCase: StartCasualGameUseCase,
    private val timedModeUseCase: StartTimedGameUseCase,
    private val survivalModeUseCase: StartSurvivalGameUseCase
) {
    suspend fun invoke(gameMode: GameMode) {
        gameSession.isGameOver = false
        gameSession.score = 0
        triviaRepository.saveScore(gameSession.score)

        when (gameMode) {
            GameMode.CASUAL -> casualModeUseCase.invoke()
            GameMode.TIMED -> timedModeUseCase.invoke()
            GameMode.SURVIVAL -> survivalModeUseCase.invoke()
        }
    }
}
