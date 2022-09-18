package com.example.meat.data.entity

import com.google.gson.annotations.SerializedName

data class ProductData(
    val key: String,
    @SerializedName("category_key")
    val categoryKey: String,
    val name: String,
    val price: Int,
    val thumbnail: String,
    val order: Int
)