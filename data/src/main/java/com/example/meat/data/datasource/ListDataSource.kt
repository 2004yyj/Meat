package com.example.meat.data.datasource

import com.example.meat.domain.model.Category
import com.example.meat.domain.model.ListModel
import com.example.meat.domain.model.Product
import kotlinx.coroutines.flow.Flow

interface ListDataSource {
    fun getList(): Flow<ListModel>
}