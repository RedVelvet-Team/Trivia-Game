package com.redvelvet.domain.model

enum class QuestionQueryModel {
    ByCategory, ByDifficulty, ByState, ByType, LastCreated, LastReviewed;

    override fun toString(): String {
        return when (this) {
            ByCategory -> "byCategory"
            ByDifficulty -> "byDifficulty"
            ByState -> "byState"
            ByType -> "byType"
            LastCreated -> "lastCreated"
            LastReviewed -> "lastReviewed"
        }
    }
}