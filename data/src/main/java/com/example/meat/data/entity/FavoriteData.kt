package com.example.meat.data.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "Favorite")
data class FavoriteData(
    val key: String,
    val categoryKey: String,
    val name: String,
    val price: Int,
    val thumbnail: String,
    val order: Int
) {
    @PrimaryKey(autoGenerate = true)
    var id: Long = 0
}