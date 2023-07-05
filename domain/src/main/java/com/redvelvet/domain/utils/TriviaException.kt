package com.redvelvet.domain.utils

sealed class TriviaException : Throwable() {
    class NoMoreQuestionsException : Exception("No more questions are available")
}