package com.redvelvet.domain.model

data class QuestionImageChoiceEntity(
    val category: String,
    val correctAnswer: List<CorrectAnswerEntity>,
    val difficulty: String,
    val id: String,
    val incorrectAnswers: List<IncorrectAnswerEntity>,
    val isNiche: Boolean,
    val question: QuestionTextEntity,
    val regions: List<Any>,
    val tags: List<String>,
    val type: String
)
