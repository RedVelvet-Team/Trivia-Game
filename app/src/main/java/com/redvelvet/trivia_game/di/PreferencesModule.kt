package com.redvelvet.trivia_game.di

import com.redvelvet.trivia_game.data.local.preferences.source.PreferencesDataSource
import com.redvelvet.trivia_game.data.local.preferences.source.PreferencesDataSourceImpl
import com.redvelvet.trivia_game.data.local.preferences.store.PreferencesDataStore
import com.redvelvet.trivia_game.data.local.preferences.store.PreferencesDataStoreDataStoreImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class PreferencesModule {

    @Binds
    @Singleton
    abstract fun bindPreferencesDataSource(
        preferencesDataSourceImpl: PreferencesDataSourceImpl
    ): PreferencesDataSource

    @Binds
    @Singleton
    abstract fun bindPreferencesDataStore(
        preferencesDataStoreDataStoreImpl: PreferencesDataStoreDataStoreImpl
    ): PreferencesDataStore


}