package com.example.meat.data.mapper

import com.example.meat.data.entity.CategoryData
import com.example.meat.domain.model.Category

fun CategoryData.toModel(): Category {
    return Category(
        key, name, order
    )
}