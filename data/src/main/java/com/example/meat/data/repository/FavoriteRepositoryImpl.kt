package com.example.meat.data.repository

import androidx.paging.PagingData
import com.example.meat.data.datasource.FavoriteDataSource
import com.example.meat.domain.model.Product
import com.example.meat.domain.repository.FavoriteRepository
import kotlinx.coroutines.flow.Flow

class FavoriteRepositoryImpl(
    private val dataSource: FavoriteDataSource
): FavoriteRepository {
    override suspend fun insertFavorite(product: Product): Long {
        return dataSource.insertFavorite(product)
    }

    override suspend fun deleteFavorite(key: String) {
        dataSource.deleteFavorite(key)
    }

    override suspend fun isExistsFavorite(key: String): Boolean {
        return dataSource.isExistsFavorite(key)
    }

    override fun searchFavorite(): Flow<PagingData<Product>> {
        return dataSource.searchFavorite()
    }

    override fun searchFavorite(query: String): Flow<PagingData<Product>> {
        return dataSource.searchFavorite(query)
    }
}