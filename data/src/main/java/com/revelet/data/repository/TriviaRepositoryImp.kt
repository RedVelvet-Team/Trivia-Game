package com.revelet.data.repository

import com.redvelvet.domain.repository.ITriviaRepository

class TriviaRepositoryImp() : ITriviaRepository {
    override suspend fun getRandomSetOfQuestion(
        limit: Int?,
        categories: String?,
        difficulties: String?,
        types: String?
    ) {
        TODO("Not yet implemented")
    }

}