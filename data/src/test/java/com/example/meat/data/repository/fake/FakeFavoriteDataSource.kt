package com.example.meat.data.repository.fake

import androidx.paging.PagingData
import com.example.meat.data.datasource.FavoriteDataSource
import com.example.meat.domain.model.Product
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class FakeFavoriteDataSource : FavoriteDataSource {
    private val list = arrayListOf(
        Product(
            "pork01",
            "pork",
            "삼겹살",
            19800,
            "https://android-test.yookgak.com/static/JeongyookgakLogo.png",
            0
        ),
        Product(
            "pork02",
            "pork",
            "목살",
            19800,
            "https://android-test.yookgak.com/static/JeongyookgakLogo.png",
            0
        )
    )

    override suspend fun insertFavorite(product: Product): Long {
        val id = list.size + 1
        list.add(product)
        return id.toLong()
    }

    override suspend fun deleteFavorite(key: String) {
        val deleteItem = list.find { it.key == key }
        list.remove(deleteItem)
    }

    override suspend fun isExistsFavorite(key: String): Boolean {
        return list.any { it.key == key }
    }

    override fun getAllFavorite(): Flow<List<Product>> = flow {
        emit(list)
    }

    override fun searchFavorite(): Flow<PagingData<Product>> = flow {
        emit(PagingData.from(list))
    }

    override fun searchFavorite(query: String): Flow<PagingData<Product>> = flow {
        val queriedList = list.filter { it.name.contains(query) }
        emit(PagingData.from(queriedList))
    }

}
