package com.redvelvet.data.remote

import com.redvelvet.data.remote.dto.QuestionDto
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query


interface ApiService {
    @GET("questions")
    suspend fun getRandomSetOfQuestion(
        @Query("limit") limit: Int,
        @Query("categories") categories: String,
        @Query("difficulties") difficulties: String,
        @Query("types") types: String,
    ): Response<List<QuestionDto>>

}