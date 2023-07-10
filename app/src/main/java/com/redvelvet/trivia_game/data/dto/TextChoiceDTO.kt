package com.redvelvet.trivia_game.data.dto


import com.google.gson.annotations.SerializedName


data class TextChoiceDTO(
    @SerializedName("category")
    val category: String,
    @SerializedName("id")
    val id: String,
    @SerializedName("correctAnswer")
    val correctAnswer: String,
    @SerializedName("incorrectAnswers")
    val incorrectAnswers: List<String>,
    @SerializedName("question")
    val question: Question,
    @SerializedName("tags")
    val tags: List<String>,
    @SerializedName("type")
    val type: String,
    @SerializedName("difficulty")
    val difficulty: String,
    @SerializedName("regions")
    val regions: List<String>,
    @SerializedName("isNiche")
    val isNiche: Boolean
) {
    data class Question(
        @SerializedName("text")
        val text: String
    )
}

/*
class TextChoiceDTO : ArrayList<TextChoiceDTO.TextChoiceDTOItem>(){

}*/
