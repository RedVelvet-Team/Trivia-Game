package com.revelet.data.remot.dto

import com.google.gson.annotations.SerializedName

data class QuestionByTypeDto(
    @SerializedName("image_choice")
    val imageChoice: Int? = null,
    @SerializedName("text_choice")
    val textChoice: Int? = null
)