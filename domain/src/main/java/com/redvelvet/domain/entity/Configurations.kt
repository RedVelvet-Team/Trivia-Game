package com.redvelvet.domain.entity

data class Configurations(
    val categories: List<String>,
    val difficulties: List<String>,
    val types: String = "text_choice",
    val limit: Int = 10,

    )