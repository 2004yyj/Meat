package com.example.meat.domain.usecase.favorite

import androidx.paging.PagingData
import com.example.meat.domain.model.Product
import com.example.meat.domain.repository.FavoriteRepository
import kotlinx.coroutines.flow.Flow

class SearchFavoriteUseCase(
    private val favoriteRepository: FavoriteRepository
) {
    operator fun invoke(query: String): Flow<PagingData<Product>> {
        return if (query.isEmpty()) {
            favoriteRepository.searchFavorite()
        } else {
            favoriteRepository.searchFavorite(query)
        }
    }
}