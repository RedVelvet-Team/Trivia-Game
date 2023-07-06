package com.redvelvet.trivia_game.di

import com.redvelvet.data.repository.ITriviaRepositoryImpl
import com.redvelvet.domain.repository.ITriviaRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {
    @Binds
    @Singleton
    abstract fun bindITriviaRepository(
        triviaRepositoryImpl: ITriviaRepositoryImpl
    ): ITriviaRepository
}