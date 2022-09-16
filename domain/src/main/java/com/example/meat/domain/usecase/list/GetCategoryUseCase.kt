package com.example.meat.domain.usecase.list

import com.example.meat.domain.model.Category
import com.example.meat.domain.repository.ListRepository
import kotlinx.coroutines.flow.Flow

class GetCategoryUseCase(
    private val listRepository: ListRepository
) {
    operator fun invoke(): Flow<List<Category>> = listRepository.getCategory()
}