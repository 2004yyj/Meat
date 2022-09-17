package com.example.meat.data.datasource.fake

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.example.meat.data.entity.FavoriteData
import com.example.meat.data.local.dao.FavoriteDao
import junit.runner.Version.id

class FakeFavoriteDao: FavoriteDao {
    private val list = arrayListOf(
        FavoriteData(
            "pork01",
            "pork",
            "삼겹살",
            19800,
            "https://android-test.yookgak.com/static/JeongyookgakLogo.png",
            0
        ).apply { id = 1L },
        FavoriteData(
            "pork02",
            "pork",
            "목살",
            19800,
            "https://android-test.yookgak.com/static/JeongyookgakLogo.png",
            0
        ).apply { id = 2L }
    )

    override suspend fun insertFavorite(favoriteData: FavoriteData): Long {
        val id = list.size + 1
        list.add(favoriteData.apply { this.id = id.toLong() })
        return favoriteData.id
    }

    override suspend fun deleteFavorite(key: String) {
        val deleteItem = list.find { it.key == key }
        list.remove(deleteItem)
    }

    override suspend fun isExistsFavorite(key: String): Boolean {
        return list.any { it.key == key }
    }

    override fun searchFavorite(): PagingSource<Int, FavoriteData> {
        return FakeFavoritePagingSource(list)
    }

    override fun searchFavorite(query: String): PagingSource<Int, FavoriteData> {
        val queriedList = list.filter { it.name.contains(query) }
        return FakeFavoritePagingSource(queriedList)
    }
}

class FakeFavoritePagingSource(
    private val list: List<FavoriteData>
) : PagingSource<Int, FavoriteData>() {
    override fun getRefreshKey(state: PagingState<Int, FavoriteData>): Int? {
        return state.anchorPosition?.let { anchorPosition ->
            state.closestItemToPosition(anchorPosition)?.id?.toInt()
        }
    }
    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, FavoriteData> {
        return LoadResult.Page(
            data = list,
            prevKey = null,
            nextKey = null
        )
    }
}