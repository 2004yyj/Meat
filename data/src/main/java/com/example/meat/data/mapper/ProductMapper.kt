package com.example.meat.data.mapper

import com.example.meat.data.entity.ProductData
import com.example.meat.domain.model.Product

fun ProductData.toModel(): Product {
    return Product(
        key, categoryKey, name, price, thumbnail, order
    )
}