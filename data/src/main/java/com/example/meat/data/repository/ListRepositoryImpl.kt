package com.example.meat.data.repository

import com.example.meat.data.datasource.ListDataSource
import com.example.meat.domain.model.Category
import com.example.meat.domain.model.Product
import com.example.meat.domain.repository.ListRepository
import kotlinx.coroutines.flow.Flow

class ListRepositoryImpl(
    private val dataSource: ListDataSource
): ListRepository {
    override fun getCategory(): Flow<List<Category>> {
        return dataSource.getCategory()
    }

    override fun getProductByCategory(categoryKey: String): Flow<List<Product>> {
        return dataSource.getProductByCategory(categoryKey)
    }
}