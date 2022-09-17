package com.example.meat.data.mapper

import com.example.meat.data.entity.FavoriteData
import com.example.meat.domain.model.Product

fun FavoriteData.toModel(): Product {
    return Product(
        key, categoryKey, name, price, thumbnail, order
    ).apply {
        favorite = true
    }
}

fun Product.toFavoriteEntity(): FavoriteData {
    return FavoriteData(
        key, categoryKey, name, price, thumbnail, order
    )
}