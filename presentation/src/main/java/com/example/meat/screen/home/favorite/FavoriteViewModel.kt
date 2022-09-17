package com.example.meat.screen.home.favorite

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.PagingData
import com.example.meat.domain.model.Product
import com.example.meat.domain.usecase.favorite.SearchFavoriteUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class FavoriteViewModel @Inject constructor(
    private val searchFavoriteUseCase: SearchFavoriteUseCase
): ViewModel() {
    private val _product: MutableStateFlow<PagingData<Product>> = MutableStateFlow(PagingData.empty())
    val product = _product.asStateFlow()

    fun searchFavorite(query: String) {
        viewModelScope.launch {
            searchFavoriteUseCase(query).collect {
                _product.emit(it)
            }
        }
    }
}
