package com.example.meat.data.datasource

import com.example.meat.data.entity.ListData
import kotlinx.coroutines.flow.Flow
import retrofit2.Response

interface ListDataSource {
    fun getList(): Flow<ListData>
}