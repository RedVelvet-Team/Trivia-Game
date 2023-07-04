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
    val science: Int? = null,
    @SerializedName("arts_and_literature")
    val artsAndLiterature: Int? = null,
    @SerializedName("film_and_tv")
    val filmAndTv: Int? = null,
    @SerializedName("general_knowledge")
    val generalKnowledge: Int? = null,
    @SerializedName("society_and_culture")
    val societyAndCulture: Int? = null,
    @SerializedName("music")
    val music: Int? = null,
    @SerializedName("sport_and_leisure")
    val sportAndLeisure: Int? = null

)
