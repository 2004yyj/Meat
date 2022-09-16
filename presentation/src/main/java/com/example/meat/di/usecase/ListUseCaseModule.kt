package com.example.meat.di.usecase

import com.example.meat.domain.repository.ListRepository
import com.example.meat.domain.usecase.list.GetCategoryUseCase
import com.example.meat.domain.usecase.list.GetProductWithCategoryUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object ListUseCaseModule {
    @Provides
    fun providesGetCategoryUseCase(listRepository: ListRepository): GetCategoryUseCase {
        return GetCategoryUseCase(listRepository)
    }

    @Provides
    fun providesGetProductUseCase(listRepository: ListRepository): GetProductWithCategoryUseCase {
        return GetProductWithCategoryUseCase(listRepository)
    }
}