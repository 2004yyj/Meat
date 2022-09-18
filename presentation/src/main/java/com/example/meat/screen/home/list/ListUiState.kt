package com.example.meat.screen.home.list

import com.example.meat.domain.model.Product

sealed class ListUiState {
    object Loading: ListUiState()
    class Success(val value: Map<String, List<Product>>): ListUiState()
}