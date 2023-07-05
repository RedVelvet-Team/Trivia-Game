package com.redvelvet.domain.usecases

import javax.inject.Inject

class SubmitAnswerUseCase @Inject constructor(
    private val startGameUseCase: StartGameUseCase,
    private val checkAnswerUseCase: CheckAnswerUseCase,
    private val endGameUseCase: EndGameUseCase,
    private val nextQuestionUseCase: NextQuestionUseCase,
) {
    suspend fun invoke(answer: String) {
        if (checkAnswerUseCase.invoke(answer)) {
            startGameUseCase.getGameSession().score + 10
            nextQuestionUseCase.invoke()
        } else if (startGameUseCase.gameMode == 3) {
            endGameUseCase.invoke()
        } else {
            nextQuestionUseCase.invoke()
        }

    }
}
