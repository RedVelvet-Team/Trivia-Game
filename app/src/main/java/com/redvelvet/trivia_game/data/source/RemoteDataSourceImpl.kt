package com.redvelvet.trivia_game.data.source

import com.redvelvet.trivia_game.data.remote.ApiService
import com.redvelvet.trivia_game.data.remote.dto.QuestionDto
import com.redvelvet.trivia_game.domain.utils.TriviaException
import retrofit2.Response
import javax.inject.Inject

class RemoteDataSourceImpl @Inject constructor(
    private val apiService: ApiService
) : RemoteDataSource {


    override suspend fun getRandomSetOfQuestion(
        limit: Int, categories: String, difficulties: String, types: String
    ): List<QuestionDto> {
        return wrapResponse {
            apiService.getRandomSetOfQuestion(limit, categories, difficulties, types)
        }
    }

    private suspend fun <T> wrapResponse(call: suspend () -> Response<T>): T {
        try {
            val response = call()
            return if (response.isSuccessful) {
                response.body() ?: throw TriviaException.NoContentFound()
            } else {
                if (response.code() == 401) {
                    throw TriviaException.UnAuthorizedRequest()
                } else {
                    response.body()!!
                }
            }
        } catch (e: TriviaException) {
            throw when (e) {
                is TriviaException.ConnectionTimeOut -> TriviaException.ConnectionTimeOut()
                is TriviaException.NoInternetConnection -> TriviaException.NoInternetConnection()
                else -> throw TriviaException.UnknownError()
            }
        }
    }
}