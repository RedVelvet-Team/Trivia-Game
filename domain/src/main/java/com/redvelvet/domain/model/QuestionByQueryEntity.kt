package com.redvelvet.domain.model

data class QuestionByQueryEntity(
    val byCategory: QuestionByCategoryEntity,
    val byDifficulty: QuestionByDifficultyEntitiy,
    val byState: QuestionByStateEntity,
    val byType: QuestionByTypeEntity,
    val lastCreated: String,
    val lastReviewed: String
)
