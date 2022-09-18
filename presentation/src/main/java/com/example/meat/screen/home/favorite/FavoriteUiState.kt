package com.example.meat.screen.home.favorite

import androidx.paging.PagingData
import com.example.meat.domain.model.Product
import kotlinx.coroutines.flow.Flow

sealed class FavoriteUiState {
    object Loading: FavoriteUiState()
    class Success(val value: Flow<PagingData<Product>>): FavoriteUiState()
}