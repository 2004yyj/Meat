package com.example.meat.di

import com.example.meat.data.datasource.ListDataSource
import com.example.meat.data.local.datasource.FavoriteDataSourceImpl
import com.example.meat.data.remote.datasource.ListDataSourceImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class DataSourceModule {
    @Binds
    abstract fun bindsListDataSource(dataSource: ListDataSourceImpl): ListDataSource

    @Binds
    abstract fun bindsFavoriteDataSource(dataSource: FavoriteDataSourceImpl): FavoriteDataSourceImpl
}