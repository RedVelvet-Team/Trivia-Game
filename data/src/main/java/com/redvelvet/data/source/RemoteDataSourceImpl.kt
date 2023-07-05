package com.redvelvet.data.source

import com.redvelvet.data.remote.ApiService
import com.redvelvet.data.remote.dto.QuestionDto
import okhttp3.internal.http2.ConnectionShutdownException
import retrofit2.Response
import java.io.IOException
import java.net.SocketTimeoutException
import java.net.UnknownHostException
import javax.inject.Inject

class RemoteDataSourceImpl @Inject constructor(
    private val apiService: ApiService
) : RemoteDataSource {


    override suspend fun getRandomSetOfQuestion(
        limit: Int?,
        categories: String?,
        difficulties: String?,
        types: String?
    ): List<QuestionDto> {
//        return wrapResponse {
//            apiService.getRandomSetOfQuestion(
//                limit,
//                categories,
//                difficulties,
//                types
//            )
//        }
        return emptyList()
    }

    private suspend fun <T> wrapResponse(call: suspend () -> Response<T>): T {
        try {
            val response = call()
            if (response.isSuccessful) return response.body() ?: throw IOException()
            else throw IOException(response.message())
        } catch (e: Exception) {
            throw when (e) {
                is SocketTimeoutException -> IOException("Connection timeout")
                is ConnectionShutdownException -> IOException("Connection shutdown")
                is UnknownHostException -> IOException("Unknown host")
                else -> e
            }
        }
    }
}