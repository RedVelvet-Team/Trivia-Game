package com.redvelvet.data.repository

import com.redvelvet.data.source.RemoteDataSource
import com.redvelvet.domain.repository.ITriviaRepository
import javax.inject.Inject

class ITriviaRepositoryImpl @Inject constructor(
    remoteDataSource: RemoteDataSource
) : ITriviaRepository {

    override suspend fun getQuestionsRandomly() {
        TODO("Not yet implemented")
    }

    override suspend fun getQuestionsByLimit(limit: Int, types: String) {
        TODO("Not yet implemented")
    }

    override suspend fun getQuestionsByTag(limit: Int, vararg tag: String, types: String) {
        TODO("Not yet implemented")
    }

    override suspend fun getQuestionsByLevel(
        limit: Int, vararg difficulties: String, types: String
    ) {
        TODO("Not yet implemented")
    }

    override suspend fun getQuestionsByCategories(
        limit: Int, vararg category: String, types: String
    ) {
        TODO("Not yet implemented")
    }
}