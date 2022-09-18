package com.example.meat.di.usecase

import com.example.meat.domain.repository.FavoriteRepository
import com.example.meat.domain.usecase.favorite.FavoriteStateChangeUseCase
import com.example.meat.domain.usecase.favorite.IsExistsFavoriteUseCase
import com.example.meat.domain.usecase.favorite.SearchFavoriteUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object FavoriteUseCaseModule {
    @Provides
    fun providesFavoriteStateChange(favoriteRepository: FavoriteRepository): FavoriteStateChangeUseCase {
        return FavoriteStateChangeUseCase(favoriteRepository)
    }

    @Provides
    fun providesSearchFavoriteUseCase(favoriteRepository: FavoriteRepository): SearchFavoriteUseCase {
        return SearchFavoriteUseCase(favoriteRepository)
    }

    @Provides
    fun providesIsExistsFavoriteUseCase(favoriteRepository: FavoriteRepository): IsExistsFavoriteUseCase {
        return IsExistsFavoriteUseCase(favoriteRepository)
    }
}