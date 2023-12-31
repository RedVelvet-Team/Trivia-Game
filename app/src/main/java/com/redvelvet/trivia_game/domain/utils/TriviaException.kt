package com.redvelvet.trivia_game.domain.utils

sealed class TriviaException(message: String) : Exception(message) {
    class NoInternetConnection: TriviaException("No Internet Connection")
    class ConnectionTimeOut: TriviaException("Connection TimeOut")
    class NoContentFound: TriviaException("No Content Found")
    class UnAuthorizedRequest: TriviaException("Un Authorized Request")
    class UnknownError: TriviaException("Unknown Error")
}