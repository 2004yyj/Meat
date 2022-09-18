package com.example.meat.screen.detail

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.meat.domain.model.Product
import com.example.meat.domain.usecase.favorite.FavoriteStateChangeUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DetailViewModel @Inject constructor(
    private val favoriteStateChangeUseCase: FavoriteStateChangeUseCase
): ViewModel() {
    fun favoriteStateChange(product: Product) {
        viewModelScope.launch {
            favoriteStateChangeUseCase(product)
        }
    }
}
