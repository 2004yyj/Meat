package com.example.meat.screen.home.favorite

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.paging.compose.collectAsLazyPagingItems
import androidx.paging.compose.itemsIndexed
import com.example.meat.domain.model.Product
import com.example.meat.screen.home.item.ProductItem

@Composable
fun Favorite(
    viewModel: FavoriteViewModel = hiltViewModel(),
    onClickProduct: (Product) -> Unit
) {
    var query by remember { mutableStateOf("") }
    val product = viewModel.product.collectAsLazyPagingItems()

    LaunchedEffect(query) {
        viewModel.searchFavorite(query)
    }

    Column(modifier = Modifier.fillMaxSize()) {
        OutlinedTextField(
            value = query,
            onValueChange = {
                query = it
            },
            placeholder = { Text(text = "검색어를 입력하세요") },
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 10.dp)
                .padding(top = 10.dp),
        )

        LazyColumn(
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f)
        ) {
            itemsIndexed(items = product) { index, item ->
                item?.let {
                    ProductItem(
                        modifier = Modifier.padding(10.dp),
                        product = item,
                        onClick = onClickProduct,
                        onClickFavorite = {
                            viewModel.favoriteStateChange(it)
                        }
                    )
                    if (index == product.itemCount - 1 && index != 0) {
                        Spacer(modifier = Modifier.height(10.dp))
                    }
                }
            }
        }
    }
}