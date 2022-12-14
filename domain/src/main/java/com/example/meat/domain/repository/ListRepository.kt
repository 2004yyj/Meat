package com.example.meat.domain.repository

import com.example.meat.domain.model.Category
import com.example.meat.domain.model.ListModel
import com.example.meat.domain.model.Product
import kotlinx.coroutines.flow.Flow

interface ListRepository {
    fun getList(): Flow<ListModel>
}