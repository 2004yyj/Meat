package com.example.meat.domain.usecase.list

import com.example.meat.domain.model.Product
import com.example.meat.domain.repository.ListRepository
import kotlinx.coroutines.flow.Flow

class GetProductWithCategoryUseCase(
    private val listRepository: ListRepository
) {
    operator fun invoke(): Flow<Map<String, List<Product>>> =
        listRepository.getProductWithCategory()
}