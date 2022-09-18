package com.example.meat.data.paging

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.example.meat.data.entity.FavoriteData

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