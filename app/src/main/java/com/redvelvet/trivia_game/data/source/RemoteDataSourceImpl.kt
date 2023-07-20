package com.redvelvet.trivia_game.data.source

import com.redvelvet.trivia_game.data.remote.ApiService
import com.redvelvet.trivia_game.data.remote.dto.QuestionDto
import com.redvelvet.trivia_game.domain.utils.TriviaException
import retrofit2.Response
import java.net.SocketTimeoutException
import java.net.UnknownHostException
import javax.inject.Inject

class RemoteDataSourceImpl @Inject constructor(
    private val apiService: ApiService
) : RemoteDataSource {


    override suspend fun getRandomSetOfQuestion(
        limit: Int,
        categories: String,
        difficulties: String,
        types: String
    ): List<QuestionDto> {
        return wrapResponse {
            apiService.getRandomSetOfQuestion(limit,categories,difficulties, types)
        }
    }

    private suspend fun <T> wrapResponse(call: suspend () -> Response<T>): T {
        try {
            val response = call()
            if (response.isSuccessful) {
                return response.body() ?: throw TriviaException.NoContentFound()
            } else {
                throw when (response.code()) {
                    401 -> TriviaException.UnAuthorizedRequest()
                    else -> throw TriviaException.UnknownError()
                }
            }
        } catch (e: Exception) {
            throw when (e) {
                is SocketTimeoutException -> TriviaException.ConnectionTimeOut()
                is UnknownHostException -> TriviaException.NoInternetConnection()
                else -> throw TriviaException.UnknownError()
            }
        }
    }
}