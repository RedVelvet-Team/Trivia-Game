package com.revelet.data.repository

import com.redvelvet.domain.repository.ITriviaRepository

class TriviaRepositoryImp() : ITriviaRepository {
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
        limit: Int,
        vararg difficulties: String,
        types: String
    ) {
        TODO("Not yet implemented")
    }

    override suspend fun getQuestionsByCategories(
        limit: Int,
        vararg category: String,
        types: String
    ) {
        TODO("Not yet implemented")
    }
}