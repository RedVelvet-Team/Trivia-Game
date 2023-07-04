package com.revelet.data.remote.dto

data class QuizDto(
	val questions: List<QuestionsItem?>? = null,
	val id: String? = null,
	val title: String? = null
)

data class QuestionsItem(
	val difficulty: String? = null,
	val incorrectAnswers: List<String?>? = null,
	val regions: List<String?>? = null,
	val isNiche: Boolean? = null,
	val question: Question? = null,
	val id: String? = null,
	val category: String? = null,
	val correctAnswer: String? = null,
	val type: String? = null,
	val tags: List<String?>? = null
)

data class Question(
	val text: String? = null
)

