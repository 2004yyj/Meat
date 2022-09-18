package com.example.meat.screen.home.list

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.meat.domain.model.Product
import com.example.meat.domain.usecase.favorite.FavoriteStateChangeUseCase
import com.example.meat.domain.usecase.list.GetProductUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ListViewModel @Inject constructor(
    private val getProductUseCase: GetProductUseCase,
    private val favoriteStateChangeUseCase: FavoriteStateChangeUseCase
): ViewModel() {
    private val _product: MutableStateFlow<Map<String, List<Product>>> = MutableStateFlow(emptyMap())
    val product = _product.asStateFlow()

    fun getProduct() {
        viewModelScope.launch {
            getProductUseCase().collect {
                _product.emit(it)
            }
        }
    }

    fun favoriteStateChange(product: Product) {
        viewModelScope.launch(Dispatchers.IO) {
            favoriteStateChangeUseCase(product)
        }
    }
}