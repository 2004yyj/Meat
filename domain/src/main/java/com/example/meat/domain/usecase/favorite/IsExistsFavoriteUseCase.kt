package com.example.meat.domain.usecase.favorite

import com.example.meat.domain.repository.FavoriteRepository

class IsExistsFavoriteUseCase(
    private val favoriteRepository: FavoriteRepository
) {
    suspend operator fun invoke(key: String): Boolean {
        return favoriteRepository.isExistsFavorite(key)
    }
}