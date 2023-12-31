package com.redvelvet.trivia_game.domain.entity

data class Question(
    val category: String,
    val correctAnswer: String,
    val difficulty: String,
    val incorrectAnswers: List<String>,
    val question: String,
    val type: String
)