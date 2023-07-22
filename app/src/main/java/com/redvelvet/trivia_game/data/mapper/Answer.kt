package com.redvelvet.trivia_game.data.mapper

import com.redvelvet.trivia_game.domain.entity.CorrectAnswer
import com.revelet.data.remot.dto.AnswerDTO

fun AnswerDTO.toAnswerEntity() = CorrectAnswer(
    height = height ?: 0,
    size = size ?: 0,
    url = url ?: "",
    width = width ?: 0
)