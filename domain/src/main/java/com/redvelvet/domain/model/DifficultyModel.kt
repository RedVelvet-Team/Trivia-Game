package com.redvelvet.domain.model

enum class DifficultyModel {
    HARD, MEDIUM, EASY;

    override fun toString(): String {
        return when(this){
            HARD -> "hard"
            MEDIUM -> "medium"
            EASY -> "easy"
        }
    }
}