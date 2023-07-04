package com.redvelvet.data.remote.dto

import com.google.gson.annotations.SerializedName

data class QuestionByStateDto(
    @SerializedName("approved")
    val approved: Int? = null,
    @SerializedName("pending")
    val pending: Int? = null,
    @SerializedName("rejected")
    val rejected: Int? = null
)