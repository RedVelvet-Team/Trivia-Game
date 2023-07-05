package com.redvelvet.data.repository

import com.redvelvet.data.mapper.toQuestionEntity
import com.redvelvet.data.source.RemoteDataSource
import com.redvelvet.domain.entity.QuestionEntity
import com.redvelvet.domain.repository.ITriviaRepository
import javax.inject.Inject

class ITriviaRepositoryImpl @Inject constructor(
    private val remoteDataSource: RemoteDataSource
) : ITriviaRepository {

    override suspend fun getRandomSetOfQuestion(
        limit: Int?,
        categories: String?,
        difficulties: String?,
        types: String?
    ): List<QuestionEntity> {
        return remoteDataSource.getRandomSetOfQuestion(
            categories = categories,
            limit = limit,
            difficulties = difficulties,
           types = types
        ).map { it.toQuestionEntity() }

    }
}