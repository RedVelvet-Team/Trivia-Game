package com.redvelvet.domain.model

data class QuestionByQueryEntity(
    val byCategory: QuestionByCategoryDto,
    val byDifficulty: QuestionByDifficultyDto,
    val byState: QuestionByStateDto,
    val byType: QuestionByTypeDto,
    val lastCreated: String,
    val lastReviewed: String
)
