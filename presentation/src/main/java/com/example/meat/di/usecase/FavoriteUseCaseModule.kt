package com.example.meat.di.usecase

import com.example.meat.domain.repository.FavoriteRepository
import com.example.meat.domain.usecase.favorite.FavoriteUseCase
import com.example.meat.domain.usecase.favorite.SearchFavoriteUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object FavoriteUseCaseModule {
    @Provides
    fun providesFavoriteUseCase(favoriteRepository: FavoriteRepository): FavoriteUseCase {
        return FavoriteUseCase(favoriteRepository)
    }

    @Provides
    fun providesSearchFavoriteUseCase(favoriteRepository: FavoriteRepository): SearchFavoriteUseCase {
        return SearchFavoriteUseCase(favoriteRepository)
    }
}