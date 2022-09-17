package com.example.meat.di

import com.example.meat.data.datasource.ListDataSource
import com.example.meat.data.remote.datasource.ListDataSourceImpl
import com.example.meat.data.remote.service.ListService
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class DataSourceModule {
    @Binds
    abstract fun bindsListDataSource(dataSource: ListDataSourceImpl): ListDataSource
}