package com.redvelvet.domain.usecases

import com.redvelvet.domain.entity.Question
import javax.inject.Inject

class GameSession @Inject constructor() {
    var score: Int = 0
    var currentQuestion: Question? = null

}