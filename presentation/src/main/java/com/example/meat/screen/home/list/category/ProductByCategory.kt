package com.example.meat.screen.home.list.category

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.meat.domain.model.Product
import com.example.meat.screen.home.item.ProductItem

@Composable
fun ProductByCategory(
    product: List<Product>,
    onClickProduct: (Product) -> Unit,
    onClickFavorite: (Product) -> Unit
) {
    LazyColumn(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        items(product.size, { product[it].key }) { index: Int ->
            ProductItem(
                modifier = Modifier.padding(10.dp),
                product = product[index],
                onClick = onClickProduct,
                onClickFavorite = {
                    onClickFavorite(it)
                }
            )
            if (index == product.size - 1) {
                Spacer(modifier = Modifier.height(10.dp))
            }
        }
    }
}