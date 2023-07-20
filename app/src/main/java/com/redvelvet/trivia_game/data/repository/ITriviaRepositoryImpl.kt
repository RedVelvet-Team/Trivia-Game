package com.redvelvet.trivia_game.data.repository

import com.redvelvet.trivia_game.data.mapper.toDomain
import com.redvelvet.trivia_game.data.source.RemoteDataSource
import com.redvelvet.trivia_game.domain.entity.Question
import com.redvelvet.trivia_game.domain.repository.ITriviaRepository
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
            categories = categories!!,
            limit = limit!!,
            difficulties = difficulties!!,
           types = types!!
        ).map { it.toDomain()}
    }
}