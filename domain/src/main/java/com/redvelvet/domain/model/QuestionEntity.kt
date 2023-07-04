package com.redvelvet.domain.model

data class QuestionEntity(
    val category: String,
    val correctAnswer: String,
    val difficulty: String,
    val id: String,
    val incorrectAnswers: List<String>,
    val isNiche: Boolean,
    val question: QuestionTextDto,
    val regions: List<String>,
    val tags: List<String>,
    val type: String
)
