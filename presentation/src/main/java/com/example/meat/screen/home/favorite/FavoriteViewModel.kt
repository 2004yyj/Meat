package com.example.meat.screen.home.favorite

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.cachedIn
import com.example.meat.domain.model.Product
import com.example.meat.domain.usecase.favorite.FavoriteStateChangeUseCase
import com.example.meat.domain.usecase.favorite.SearchFavoriteUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class FavoriteViewModel @Inject constructor(
    private val searchFavoriteUseCase: SearchFavoriteUseCase,
    private val favoriteStateChangeUseCase: FavoriteStateChangeUseCase
): ViewModel() {
    private val _uiState: MutableStateFlow<FavoriteUiState> = MutableStateFlow(FavoriteUiState.Loading)
    val uiState = _uiState.asStateFlow()

    fun searchFavorite(query: String) {
        viewModelScope.launch {
            _uiState.emit(
                FavoriteUiState.Success(
                    searchFavoriteUseCase(query)
                        .cachedIn(viewModelScope)
                )
            )
        }
    }

    fun favoriteStateChange(product: Product) {
        viewModelScope.launch(Dispatchers.IO) {
            favoriteStateChangeUseCase(product)
        }
    }
}
