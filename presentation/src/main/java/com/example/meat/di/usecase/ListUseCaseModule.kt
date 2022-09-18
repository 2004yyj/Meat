package com.example.meat.di.usecase

import com.example.meat.domain.repository.FavoriteRepository
import com.example.meat.domain.repository.ListRepository
import com.example.meat.domain.usecase.list.GetProductUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object ListUseCaseModule {
    @Provides
    fun providesGetProductUseCase(
        listRepository: ListRepository,
        favoriteRepository: FavoriteRepository
    ): GetProductUseCase {
        return GetProductUseCase(listRepository, favoriteRepository)
    }
}