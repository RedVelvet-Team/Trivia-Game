package com.redvelvet.data.remote.dto

import com.google.gson.annotations.SerializedName

data class QuestionByDifficultyDto(
    @SerializedName("easy")
    val easy: Int? = null,
    @SerializedName("hard")
    val hard: Int? = null,
    @SerializedName("medium")
    val medium: Int? = null
)