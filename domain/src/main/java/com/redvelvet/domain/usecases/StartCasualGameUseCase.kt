package com.redvelvet.domain.usecases

class StartCasualGameUseCase(
    private val gameSession: GameSession,
    private val getCustomizedQuestionsUsecase: GetCustomizedQuestionsUsecase
) {
    suspend fun invoke(modeInt: Int) {
        gameSession.score = 0
        gameSession.currentQuestion = getCustomizedQuestionsUsecase.getNextQuestion()
        gameSession.isGameOver = false
    }
}