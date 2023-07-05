package com.redvelvet.domain.usecases

import com.redvelvet.domain.entity.Configurations
import com.redvelvet.domain.utils.TriviaException
import javax.inject.Inject


class StartGameUseCase @Inject constructor(
    private val gameSession: GameSession,
    private val nextQuestionUseCase: NextQuestionUseCase,
    private val timedModeUseCase: TimedModeUseCase,
    private val getCustomizedQuestionsUsecase: GetCustomizedQuestionsUsecase
) {
    var gameMode: Int = 1

    suspend fun invoke(gameMode: Int, configurations: Configurations) {
        configureGameSettings(gameMode)
        try {
            prepareData(configurations)
        } catch (exception: Exception) {
            throw TriviaException.RequestFailedException(exception.message)
        }
    }

    private fun configureGameSettings(gameMode: Int) {
        this.gameMode = gameMode
        gameSession.score = 0
    }

    private suspend fun prepareData(configurations: Configurations) {
        getCustomizedQuestionsUsecase.invoke(configurations = configurations)
        gameSession.currentQuestion = nextQuestionUseCase.invoke()
        if (gameMode == 2) {
            timedModeUseCase.startTimer()
        }
    }

    fun getGameSession(): GameSession {
        return gameSession
    }

}


