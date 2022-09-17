package com.example.meat.di

import com.example.meat.data.repository.FavoriteRepositoryImpl
import com.example.meat.data.repository.ListRepositoryImpl
import com.example.meat.domain.repository.FavoriteRepository
import com.example.meat.domain.repository.ListRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {
    @Binds
    abstract fun bindsListRepository(repository: ListRepositoryImpl): ListRepository

    @Binds
    abstract fun bindsFavoriteRepository(repository: FavoriteRepositoryImpl): FavoriteRepository
}