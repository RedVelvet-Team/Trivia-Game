package com.redvelvet.domain.model

enum class QuestionStateModel {
    Approved, Pending, Rejected;

    override fun toString(): String {
        return when (this) {
            Approved -> "approved"
            Pending -> "pending"
            Rejected -> "rejected"
        }
    }
}