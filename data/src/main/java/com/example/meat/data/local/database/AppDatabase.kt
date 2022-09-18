package com.example.meat.data.local.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.meat.data.entity.FavoriteData
import com.example.meat.data.local.dao.FavoriteDao

@Database(entities = [FavoriteData::class], version = 1)
abstract class AppDatabase: RoomDatabase() {
    abstract fun favoriteDao(): FavoriteDao
}