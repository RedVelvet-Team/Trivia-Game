package com.revelet.data.remot.dto

import com.google.gson.annotations.SerializedName

data class QuestionDto(
    @SerializedName("category")
    val category: String? = "",
    @SerializedName("correctAnswer")
    val correctAnswer: String? = "",
    @SerializedName("difficulty")
    val difficulty: String? = "",
    @SerializedName("id")
    val id: String? = "",
    @SerializedName("incorrectAnswers")
    val incorrectAnswers: List<String>? = listOf(),
    @SerializedName("isNiche")
    val isNiche: Boolean? = false,
    @SerializedName("question")
    val question: QuestionTextDto? = QuestionTextDto(),
    @SerializedName("regions")
    val regions: List<String>? = listOf(),
    @SerializedName("tags")
    val tags: List<String>? = listOf(),
    @SerializedName("type")
    val type: String? = ""
)