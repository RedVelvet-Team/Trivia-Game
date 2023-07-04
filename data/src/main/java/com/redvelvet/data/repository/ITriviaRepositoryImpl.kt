package com.redvelvet.data.repository

import com.redvelvet.data.source.RemoteDataSource
import com.redvelvet.domain.repository.ITriviaRepository
import javax.inject.Inject

class ITriviaRepositoryImpl @Inject constructor(
    remoteDataSource: RemoteDataSource
) : ITriviaRepository {

    override suspend fun getRandomSetOfQuestion(
        limit: Int?,
        categories: String?,
        difficulties: String?,
        types: String?
    ) {
        TODO("Not yet implemented")
    }
}