package com.example.meat.data.remote.datasource

import com.example.meat.data.datasource.ListDataSource
import com.example.meat.data.mapper.toModel
import com.example.meat.data.remote.base.BaseRemote
import com.example.meat.data.remote.service.ListService
import com.example.meat.domain.model.Category
import com.example.meat.domain.model.Product
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class ListDataSourceImpl @Inject constructor(
    private val service: ListService
): ListDataSource, BaseRemote() {
    override fun getCategory(): Flow<List<Category>> = flow {
        emit(getResponse(service.getList()).toModel().categories)
    }

    override fun getProduct(): Flow<List<List<Product>>> = flow {
        val list = getResponse(service.getList()).toModel()
        val sortedAndGroupedList =
            list.productions.sortedBy {
                // 카테고리 Order별로 Sort
                list.categories.find { category -> category.key == it.categoryKey }?.order
            }.groupBy {
                // 카테고리 Key별로 Grouping
                it.categoryKey
            }.values.toList()
            // Key 빼고 value collection 받아와서 List로 변경
        emit(sortedAndGroupedList)
    }
}