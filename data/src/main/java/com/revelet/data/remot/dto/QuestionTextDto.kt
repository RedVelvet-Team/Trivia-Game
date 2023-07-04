package com.revelet.data.remot.dto

import com.google.gson.annotations.SerializedName

data class QuestionTextDto(
    @SerializedName("text")
    val text: String? = null
)