package com.redvelvet.trivia_game.di

import com.redvelvet.trivia_game.data.repository.ITriviaRepositoryImpl
import com.redvelvet.trivia_game.domain.repository.ITriviaRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent


@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {


    @Binds
    abstract fun bindRepository(
        iTriviaRepositoryImpl: ITriviaRepositoryImpl
    ): ITriviaRepository

}