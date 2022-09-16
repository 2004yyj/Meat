package com.example.meat.domain.usecase.list

import com.example.meat.domain.model.Product
import com.example.meat.domain.repository.ListRepository
import kotlinx.coroutines.flow.Flow

class GetProductUseCase(
    private val listRepository: ListRepository
) {
    operator fun invoke(): Flow<List<List<Product>>> =
        listRepository.getProduct()
}