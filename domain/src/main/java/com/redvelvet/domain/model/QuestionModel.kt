package com.redvelvet.domain.model

enum class QuestionModel {
    Category, CorrectAnswer, Difficulty, Id, IncorrectAnswers, IsNiche, Question, Regions, Type;

    override fun toString(): String {
        return when (this) {
            Category -> "category"
            CorrectAnswer -> "correctAnswer"
            Difficulty -> "difficulty"
            Id -> "id"
            IncorrectAnswers -> "incorrectAnswers"
            IsNiche -> "isNiche"
            Question -> "question"
            Regions -> "regions"
            Type -> "type"
        }
    }
}