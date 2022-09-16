package com.example.meat.di

import com.example.meat.data.remote.service.ListService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object ServiceModule {
    @Provides
    fun providesListService(retrofit: Retrofit): ListService {
        return retrofit.create(ListService::class.java)
    }
}