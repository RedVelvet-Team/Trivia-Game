package com.revelet.data.remot.dto

import com.google.gson.annotations.SerializedName

data class QuestionByCategoryDto(
    @SerializedName("food_and_drink")
    val foodAndDrink: Int? = null,
    @SerializedName("geography")
    val geography: Int? = null,
    @SerializedName("history")
    val history: Int? = null,
    @SerializedName("science")
    val science: Int? = null
)
