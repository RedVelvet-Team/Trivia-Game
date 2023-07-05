package com.redvelvet.domain.utils

sealed class TriviaException : Throwable() {
    //TODO
    class NoMoreQuestionsException : Exception("No more questions are available")
}