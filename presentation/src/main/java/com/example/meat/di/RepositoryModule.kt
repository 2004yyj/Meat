package com.example.meat.di

import com.example.meat.data.datasource.ListDataSource
import com.example.meat.data.repository.ListRepositoryImpl
import com.example.meat.domain.repository.ListRepository
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {
    @Binds
    abstract fun bindsListRepository(repository: ListRepositoryImpl): ListRepository
}