package com.redvelvet.domain.entity

data class QuestionByStateEntity(
    val approved: Int,
    val pending: Int,
    val rejected: Int,
)
