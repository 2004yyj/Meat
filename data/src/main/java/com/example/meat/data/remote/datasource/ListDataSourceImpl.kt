package com.example.meat.data.remote.datasource

import com.example.meat.data.datasource.ListDataSource
import com.example.meat.data.entity.ListData
import com.example.meat.data.remote.base.BaseRemote
import com.example.meat.data.remote.service.ListService
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class ListDataSourceImpl(
    private val service: ListService
): ListDataSource, BaseRemote() {
    override fun getList(): Flow<ListData> = flow {
        emit(getResponse(service.getList()))
    }
}