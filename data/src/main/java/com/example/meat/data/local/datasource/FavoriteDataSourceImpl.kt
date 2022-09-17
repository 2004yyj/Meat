package com.example.meat.data.local.datasource

import androidx.paging.*
import com.example.meat.data.datasource.FavoriteDataSource
import com.example.meat.data.entity.FavoriteData
import com.example.meat.data.local.dao.FavoriteDao
import com.example.meat.data.mapper.toFavoriteEntity
import com.example.meat.data.mapper.toModel
import com.example.meat.domain.model.Product
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class FavoriteDataSourceImpl @Inject constructor(
    private val dao: FavoriteDao
): FavoriteDataSource {
    override suspend fun insertFavorite(product: Product): Long {
        return dao.insertFavorite(product.toFavoriteEntity())
    }

    override suspend fun deleteFavorite(key: String) {
        return dao.deleteFavorite(key)
    }

    override suspend fun isExistsFavorite(key: String): Boolean {
        return dao.isExistsFavorite(key)
    }

    override fun getAllFavorite(): Flow<List<Product>> = flow {
        emit(dao.getAllFavorite().map { it.toModel() })
    }

    override fun searchFavorite(): Flow<PagingData<Product>> =
        Pager(PagingConfig(10)) { dao.searchFavorite() }.flow.map {
            it.map { favoriteData -> favoriteData.toModel() }
        }

    override fun searchFavorite(query: String): Flow<PagingData<Product>> =
        Pager(PagingConfig(10)) { dao.searchFavorite(query) }.flow.map {
            it.map { favoriteData -> favoriteData.toModel() }
        }
}