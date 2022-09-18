package com.example.meat.domain.model

data class Product(
    val key: String,
    val categoryKey: String,
    val name: String,
    val price: Int,
    val thumbnail: String,
    val order: Int,
    var favorite: Boolean = false
) {
}