package com.example.meat.screen.home.list

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.meat.domain.model.Category
import com.example.meat.domain.model.Product
import com.example.meat.domain.usecase.list.GetCategoryUseCase
import com.example.meat.domain.usecase.list.GetProductByCategoryUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ProductViewModel @Inject constructor(
    private val getCategoryUseCase: GetCategoryUseCase,
    private val getProductByCategoryUseCase: GetProductByCategoryUseCase
): ViewModel() {
    private val _category = MutableStateFlow(emptyList<Category>())
    val category = _category.asStateFlow()

    private val _product = MutableStateFlow(emptyList<Product>())
    val product = _product.asStateFlow()

    fun getCategory() {
        // Retrofit 내부에 Dispatchers 관련 설정이 되어있어 지정이 필요없음
        viewModelScope.launch {
            getCategoryUseCase().collect {
                _category.emit(it)
            }
        }
    }

    fun getProductByCategory(categoryKey: String) {
        viewModelScope.launch {
            getProductByCategoryUseCase(categoryKey).collect {
                _product.emit(it)
            }
        }
    }
}