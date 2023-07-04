package com.redvelvet.data.dto

import com.google.gson.annotations.SerializedName

data class ImageChoiceDTOItem(
    @SerializedName("category")
    val category: String,
    @SerializedName("id")
    val id: String,
    @SerializedName("correctAnswer")
    val correctAnswer: List<CorrectAnswer>,
    @SerializedName("incorrectAnswers")
    val incorrectAnswers: List<List<IncorrectAnswer>>,
    @SerializedName("question")
    val question: Question,
    @SerializedName("tags")
    val tags: List<String>,
    @SerializedName("type")
    val type: String,
    @SerializedName("difficulty")
    val difficulty: String,
    @SerializedName("regions")
    val regions: List<Any>,
    @SerializedName("isNiche")
    val isNiche: Boolean
) {
    data class CorrectAnswer(
        @SerializedName("url")
        val url: String,
        @SerializedName("height")
        val height: Int,
        @SerializedName("width")
        val width: Int,
        @SerializedName("author")
        val author: Author,
        @SerializedName("description")
        val description: String,
        @SerializedName("size")
        val size: Int,
        @SerializedName("source")
        val source: Source,
        @SerializedName("license")
        val license: License
    ) {
        data class Author(
            @SerializedName("url")
            val url: String,
            @SerializedName("name")
            val name: String
        )

        data class Source(
            @SerializedName("url")
            val url: Any
        )

        data class License(
            @SerializedName("url")
            val url: Any,
            @SerializedName("name")
            val name: String
        )
    }

    data class IncorrectAnswer(
        @SerializedName("url")
        val url: String,
        @SerializedName("height")
        val height: Int,
        @SerializedName("width")
        val width: Int,
        @SerializedName("author")
        val author: Author,
        @SerializedName("description")
        val description: String,
        @SerializedName("size")
        val size: Int,
        @SerializedName("source")
        val source: Source,
        @SerializedName("license")
        val license: License
    ) {
        data class Author(
            @SerializedName("url")
            val url: String,
            @SerializedName("name")
            val name: String
        )

        data class Source(
            @SerializedName("url")
            val url: String
        )

        data class License(
            @SerializedName("url")
            val url: String,
            @SerializedName("name")
            val name: String
        )
    }

    data class Question(
        @SerializedName("text")
        val text: String
    )
}
/*
class ImageChoiceDTO : ArrayList<ImageChoiceDTO.ImageChoiceDTOItem>(){

}*/
