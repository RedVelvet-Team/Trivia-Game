package com.redvelvet.domain.model

data class QuestionByStateEntity(
    val approved: Int,
    val pending: Int,
    val rejected: Int,
)
