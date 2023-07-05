package com.redvelvet.data.repository

import com.redvelvet.data.mapper.toDomain
import com.redvelvet.data.source.RemoteDataSource
import com.redvelvet.domain.entity.Question
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
    ): List<Question> {
        return remoteDataSource.getRandomSetOfQuestion(
            categories = categories,
            limit = limit,
            difficulties = difficulties,
            types = types
        ).map { it.toDomain() }

    }
}