package com.example.meat.data.local.dao

import androidx.paging.PagingSource
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.example.meat.data.entity.FavoriteData

@Dao
interface FavoriteDao {
    @Insert
    suspend fun insertFavorite(vararg favoriteData: FavoriteData): List<Long>

    @Query("DELETE FROM favorite WHERE favorite.key = :key")
    suspend fun deleteFavorite(vararg key: String)

    @Query("SELECT EXISTS (SELECT * FROM favorite WHERE favorite.key = :key)")
    suspend fun isExistsFavorite(key: String): Boolean

    @Query("SELECT * FROM favorite")
    fun searchFavorite(): PagingSource<Int, FavoriteData>

    @Query("SELECT * FROM favorite WHERE name LIKE :query")
    fun searchFavorite(query: String): PagingSource<Int, FavoriteData>
}