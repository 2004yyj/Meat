package com.example.meat.data.remote.datasource

import com.example.meat.data.datasource.ListDataSource
import com.example.meat.data.mapper.toModel
import com.example.meat.domain.model.ListModel
import com.example.meat.data.remote.base.BaseRemote
import com.example.meat.data.remote.service.ListService
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class ListDataSourceImpl(
    private val service: ListService
): ListDataSource, BaseRemote() {
    override fun getList(): Flow<ListModel> = flow {
        emit(getResponse(service.getList()).toModel())
    }
}