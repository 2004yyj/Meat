package com.example.meat.di

import com.example.meat.data.local.dao.FavoriteDao
import com.example.meat.data.local.database.AppDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object DaoModule {
    @Provides
    fun providesFavoriteDao(database: AppDatabase): FavoriteDao {
        return database.favoriteDao()
    }
}