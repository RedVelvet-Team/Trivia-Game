package com.redvelvet.domain.usecases

import com.redvelvet.domain.entity.QuestionEntity

class GameSession {
    var score: Int = 0
    var currentQuestion: QuestionEntity? = null
    var isGameOver: Boolean = false
}