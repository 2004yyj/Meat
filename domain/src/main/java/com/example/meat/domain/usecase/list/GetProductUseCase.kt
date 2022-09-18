package com.example.meat.domain.usecase.list

import com.example.meat.domain.model.Product
import com.example.meat.domain.repository.FavoriteRepository
import com.example.meat.domain.repository.ListRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class GetProductUseCase(
    private val listRepository: ListRepository,
    private val favoriteRepository: FavoriteRepository
) {
    operator fun invoke(): Flow<Map<String, List<Product>>> {
        val listFlow = listRepository.getList().map { list ->
            val sortedAndGroupedList =
                list.productions.map { product ->
                    product.favorite = favoriteRepository.isExistsFavorite(product.key)
                    product
                }.sortedBy {
                    // 카테고리 Order별로 Sort
                    list.categories.find { category -> category.key == it.categoryKey }?.order
                }.groupBy {
                    // 카테고리 Key별로 Grouping
                    it.categoryKey
                }
            sortedAndGroupedList
        }
        return listFlow
    }
}