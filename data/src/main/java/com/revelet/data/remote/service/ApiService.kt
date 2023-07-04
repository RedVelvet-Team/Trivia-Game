package com.revelet.data.remote.service

import com.revelet.data.remote.dto.QuestionDto
import com.revelet.data.remote.dto.QuestionTagsDto
import com.revelet.data.remote.dto.QuizDto
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query


interface ApiService {

    @GET("quiz/{id}")
    suspend fun getQuizById(
        @Query("id") id: String,
    ): Response<QuizDto>


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
    ): Response<QuestionDto>

}

