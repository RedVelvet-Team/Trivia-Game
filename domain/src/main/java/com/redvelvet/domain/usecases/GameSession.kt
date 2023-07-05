package com.redvelvet.domain.usecases

import com.redvelvet.domain.entity.Question

class GameSession {
    var score: Int = 0
    var currentQuestion: Question? = null
}