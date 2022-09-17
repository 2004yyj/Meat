package com.example.meat.data.datasource

import androidx.paging.PagingData
import androidx.paging.PagingSource
import com.example.meat.data.entity.FavoriteData
import com.example.meat.domain.model.Product
import kotlinx.coroutines.flow.Flow

interface FavoriteDataSource {
    suspend fun insertFavorite(product: Product): Long
    suspend fun deleteFavorite(key: String)
    suspend fun isExistsFavorite(key: String): Boolean
    fun searchFavorite(): Flow<PagingData<Product>>
    fun searchFavorite(query: String): Flow<PagingData<Product>>
}