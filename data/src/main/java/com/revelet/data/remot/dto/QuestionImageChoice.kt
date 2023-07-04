package com.revelet.data.remot.dto


import com.google.gson.annotations.SerializedName

data class QuestionImageChoice(
    @SerializedName("category")
    val category: String? = "",
    @SerializedName("correctAnswer")
    val correctAnswer: List<CorrectAnswerImageChoiceDto>? = listOf(),
    @SerializedName("difficulty")
    val difficulty: String? = "",
    @SerializedName("id")
    val id: String? = "",
    @SerializedName("incorrectAnswers")
    val incorrectAnswers: List<List<IncorrectAnswerImageChoiceDto>>? = listOf(),
    @SerializedName("isNiche")
    val isNiche: Boolean? = false,
    @SerializedName("question")
    val question: QuestionTextDto? = null,
    @SerializedName("regions")
    val regions: List<Any>? = listOf(),
    @SerializedName("tags")
    val tags: List<String>? = listOf(),
    @SerializedName("type")
    val type: String? = ""
)