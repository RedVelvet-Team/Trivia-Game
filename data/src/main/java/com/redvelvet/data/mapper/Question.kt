package com.redvelvet.data.mapper

import com.redvelvet.data.remote.dto.QuestionDto
import com.redvelvet.domain.entity.QuestionEntity

fun QuestionDto.toQuestionEntity() = QuestionEntity(
    category = category ?: "",
    correctAnswer = correctAnswer ?: "",
    difficulty = difficulty ?: "",
    id = id ?: "",
    incorrectAnswers = incorrectAnswers ?: emptyList(),
    isNiche = isNiche ?: false,
    question = question?.toQuestionTextEntity()!!,
    regions = regions ?: emptyList(),
    tags = tags ?: emptyList(),
    type = type ?: ""

)

fun QuestionDto.QuestionTextDto.toQuestionTextEntity() = QuestionEntity.QuestionTextEntity(
    text = text ?: "",

)