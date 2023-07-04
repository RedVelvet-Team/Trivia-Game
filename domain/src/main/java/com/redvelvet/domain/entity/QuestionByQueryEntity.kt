package com.redvelvet.domain.entity

data class QuestionByQueryEntity(
    val byCategory: QuestionByCategoryEntity,
    val byDifficulty: QuestionByDifficultyEntity,
    val byState: QuestionByStateEntity,
    val byType: QuestionByTypeEntity,
    val lastCreated: String,
    val lastReviewed: String
)
