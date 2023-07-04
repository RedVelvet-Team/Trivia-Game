package com.redvelvet.domain.model

data class QuestionImageChoiceEntity(
    val category: String,
    val correctAnswer: List<CorrectAnswerDto>,
    val difficulty: String,
    val id: String,
    val incorrectAnswers: List<IncorrectAnswerImageChoiceDto>,
    val isNiche: Boolean,
    val question: QuestionTextDto,
    val regions: List<Any>,
    val tags: List<String>,
    val type: String
)
