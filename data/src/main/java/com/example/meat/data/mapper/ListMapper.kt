package com.example.meat.data.mapper

import com.example.meat.data.entity.ListData
import com.example.meat.domain.model.ListModel

fun ListData.toModel(): ListModel {
    return ListModel(
        categories.map {
            it.toModel()
        },
        productions.map {
            it.toModel()
        }
    )
}