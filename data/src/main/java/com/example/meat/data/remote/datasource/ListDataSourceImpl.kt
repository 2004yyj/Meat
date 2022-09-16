package com.example.meat.data.remote.datasource

import com.example.meat.data.datasource.ListDataSource
import com.example.meat.data.mapper.toModel
import com.example.meat.data.remote.base.BaseRemote
import com.example.meat.data.remote.service.ListService
import com.example.meat.domain.model.Category
import com.example.meat.domain.model.Product
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class ListDataSourceImpl(
    private val service: ListService
): ListDataSource, BaseRemote() {
    override fun getCategory(): Flow<List<Category>> = flow {
        emit(getResponse(service.getList()).toModel().categories)
    }

    override fun getProductByCategory(categoryKey: String): Flow<List<Product>> = flow {
        val list = getResponse(service.getList()).toModel()
        emit(list.productions.filter { it.categoryKey == categoryKey })
    }
}