package com.redvelvet.data.remote.dto

import com.google.gson.annotations.SerializedName

data class QuestionNumberDto(
    @SerializedName("architecture")
    val architecture: Int? = null,
    @SerializedName("france")
    val france: Int? = null,
    @SerializedName("physics")
    val physics: Int? = null,
    @SerializedName("world_war_2")
    val worldWar2: Int? = null
)