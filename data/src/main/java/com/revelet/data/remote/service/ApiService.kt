package com.revelet.data.remote.service

import com.revelet.data.remote.dto.QuestionDto
import com.revelet.data.remote.dto.QuestionTagsDto
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query


interface ApiService {

    @GET("tags")
    suspend fun getAllTags(): Response<QuestionTagsDto>


    @GET("question/{id}")
    suspend fun getQuestionById(
        @Query("id") id: String,
    ): Response<QuestionDto>


    @GET("questions")
    suspend fun getRandomSetOfQuestion(
        @Query("limit") limit: Int,
        @Query("categories") categories: String,
        @Query("tags") tags: String,
        @Query("types") types: String,
    ): Response<QuestionDto>

}

