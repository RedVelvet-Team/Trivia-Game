package com.redvelvet.domain.utils

sealed class TriviaException : Throwable() {
    class NoMoreQuestionsException : Exception("No more questions are available")
    class RequestFailedException(message: String?) : Exception("Request failed $message")
}