package com.redvelvet.domain.model

enum class QuestionTypeModel {
    ImageChoice, TextChoice;

    override fun toString(): String {
        return when (this) {
            ImageChoice -> "image_choice"
            TextChoice -> "text_choice"
        }
    }
}