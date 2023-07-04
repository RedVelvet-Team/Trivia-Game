package com.redvelvet.domain.entity

data class QuestionEntity(
    val category: String,
    val correctAnswer: String,
    val difficulty: String,
    val id: String,
    val incorrectAnswers: List<String>,
    val isNiche: Boolean,
    val question: QuestionTextEntity,
    val regions: List<String>,
    val tags: List<String>,
    val type: String
){
    data class QuestionTextEntity(
        val text: String
    )
}
