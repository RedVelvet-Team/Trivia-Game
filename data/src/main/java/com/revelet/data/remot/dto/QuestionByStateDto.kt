package com.revelet.data.remot.dto

import com.google.gson.annotations.SerializedName

data class QuestionByStateDto(
    @SerializedName("approved")
    val approved: Int? = null,
    @SerializedName("pending")
    val pending: Int? = null,
    @SerializedName("rejected")
    val rejected: Int? = null
)