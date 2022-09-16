package com.example.meat.domain.usecase.list

import com.example.meat.domain.model.Category
import com.example.meat.domain.model.Product
import com.example.meat.domain.repository.ListRepository
import kotlinx.coroutines.flow.Flow

class GetProductByCategoryUseCase(
    private val listRepository: ListRepository
) {
    operator fun invoke(categoryKey: String): Flow<List<Product>> =
        listRepository.getProductByCategory(categoryKey)
}