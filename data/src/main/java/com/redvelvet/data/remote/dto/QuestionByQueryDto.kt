package com.redvelvet.data.remote.dto

import com.google.gson.annotations.SerializedName

data class QuestionByQueryDto(
    @SerializedName("byCategory")
    val byCategory: QuestionByCategoryDto? = null,
    @SerializedName("byDifficulty")
    val byDifficulty: QuestionByDifficultyDto? = null,
    @SerializedName("byState")
    val byState: QuestionByStateDto? = null,
    @SerializedName("byType")
    val byType: QuestionByTypeDto? = null,
    @SerializedName("lastCreated")
    val lastCreated: String? = null,
    @SerializedName("lastReviewed")
    val lastReviewed: String? = null
)