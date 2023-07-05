package com.redvelvet.data.mapper

import com.redvelvet.data.remote.dto.QuestionDto
import com.redvelvet.domain.entity.Question

fun QuestionDto.toQuestionEntity() = Question(
    category = category ?: "",
    correctAnswer = correctAnswer ?: "",
    difficulty = difficulty ?: "",
    incorrectAnswers = incorrectAnswers ?: emptyList(),
    question = this.question?.text ?: "",
    type = type ?: ""
)

