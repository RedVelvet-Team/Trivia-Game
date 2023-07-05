package com.redvelvet.domain.usecases

import com.redvelvet.domain.entity.Configurations
import javax.inject.Inject


class StartGameUseCase @Inject constructor(
    private val gameSession: GameSession,
    private val casualModeUseCase: StartCasualGameUseCase,
    private val timedModeUseCase: StartTimedGameUseCase,
    private val survivalModeUseCase: StartSurvivalGameUseCase,
    private val getCustomizedQuestionsUsecase: GetCustomizedQuestionsUsecase
) {
    suspend fun invoke(gameMode: Int, configurations: Configurations) {
        configureGameConfigurations(configurations)
        when (gameMode) {
            1 -> casualModeUseCase.invoke(gameSession)
            2 -> timedModeUseCase.invoke(gameSession)
            3 -> survivalModeUseCase.invoke(gameSession)
        }
    }

    private suspend fun configureGameConfigurations(configurations: Configurations) {
        gameSession.isGameOver = false
        gameSession.score = 0
        getCustomizedQuestionsUsecase.invoke(configurations = configurations)
    }
}


