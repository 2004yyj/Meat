package com.example.meat.domain.usecase.favorite

import com.example.meat.domain.model.Product
import com.example.meat.domain.repository.FavoriteRepository

class FavoriteUseCase(
    private val favoriteRepository: FavoriteRepository
) {
    suspend operator fun invoke(product: Product) {
        if (favoriteRepository.isExistsFavorite(product.key)) {
            favoriteRepository.deleteFavorite(product.key)
        } else {
            favoriteRepository.insertFavorite(product)
        }
    }
}