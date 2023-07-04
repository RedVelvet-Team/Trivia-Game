package com.redvelvet.trivia_game.di

import com.redvelvet.data.source.RemoteDataSource
import com.redvelvet.data.source.RemoteDataSourceImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent


@Module
@InstallIn(SingletonComponent::class)
abstract class DataSourceModule {

    @Binds
    abstract fun bindRemoteDataSource(
        remoteDataSourceImp: RemoteDataSourceImpl
    ): RemoteDataSource


}