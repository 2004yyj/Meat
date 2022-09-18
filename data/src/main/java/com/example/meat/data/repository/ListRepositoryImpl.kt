package com.example.meat.data.repository

import com.example.meat.data.datasource.ListDataSource
import com.example.meat.domain.model.Category
import com.example.meat.domain.model.ListModel
import com.example.meat.domain.repository.ListRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class ListRepositoryImpl @Inject constructor(
    private val dataSource: ListDataSource
): ListRepository {
    override fun getCategory(): Flow<List<Category>> {
        return dataSource.getCategory()
    }

    override fun getList(): Flow<ListModel> {
        return dataSource.getList()
    }
}