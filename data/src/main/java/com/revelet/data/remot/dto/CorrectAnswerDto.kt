package com.revelet.data.remot.dto


import com.google.gson.annotations.SerializedName

data class CorrectAnswerDto(
    @SerializedName("height")
    val height: Int? = null,
    @SerializedName("size")
    val size: Int? = null,
    @SerializedName("url")
    val url: String? = null,
    @SerializedName("width")
    val width: Int? = null
)