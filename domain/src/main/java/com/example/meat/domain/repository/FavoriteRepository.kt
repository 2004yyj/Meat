package com.example.meat.domain.repository

import androidx.paging.PagingData
import com.example.meat.domain.model.Product
import kotlinx.coroutines.flow.Flow

interface FavoriteRepository {
    suspend fun insertFavorite(product: Product): Long
    suspend fun deleteFavorite(key: String)
    suspend fun isExistsFavorite(key: String): Boolean
    fun searchFavorite(): Flow<PagingData<Product>>
    fun searchFavorite(query: String): Flow<PagingData<Product>>
}