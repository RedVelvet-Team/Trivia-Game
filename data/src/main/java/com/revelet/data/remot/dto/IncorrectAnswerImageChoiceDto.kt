package com.revelet.data.remot.dto


import com.google.gson.annotations.SerializedName

data class IncorrectAnswerImageChoiceDto(

    @SerializedName("description")
    val description: String? = "",
    @SerializedName("height")
    val height: Int? = 0,
    @SerializedName("size")
    val size: Int? = 0,
    @SerializedName("url")
    val url: String? = "",
    @SerializedName("width")
    val width: Int? = 0
)