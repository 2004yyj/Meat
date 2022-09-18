package com.example.meat.screen.home.list

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.ScrollableTabRow
import androidx.compose.material.Tab
import androidx.compose.material.TabRowDefaults
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.meat.domain.model.Product
import com.example.meat.screen.home.list.category.ProductByCategory
import com.google.accompanist.pager.*
import kotlinx.coroutines.launch

@OptIn(ExperimentalPagerApi::class)
@Composable
fun List(
    viewModel: ListViewModel = hiltViewModel(),
    onClickProduct: (Product) -> Unit
) {
    viewModel.getCategory()
    viewModel.getProduct()

    val coroutineScope = rememberCoroutineScope()
    val categories by viewModel.category.collectAsState()
    val products by viewModel.product.collectAsState()
    val pagerState = rememberPagerState()

    if (categories.isNotEmpty() && products.isNotEmpty()) {
        Column(modifier = Modifier.fillMaxSize()) {
            ScrollableTabRow(
                edgePadding = 0.dp,
                modifier = Modifier.fillMaxWidth(),
                selectedTabIndex = pagerState.currentPage,
                indicator = { tabPositions ->
                    TabRowDefaults.Indicator(
                        Modifier.pagerTabIndicatorOffset(pagerState, tabPositions)
                    )
                }
            ) {
                categories.forEachIndexed { index, category ->
                    Tab(
                        text = { Text(text = category.name) },
                        selected = pagerState.currentPage == index,
                        onClick = {
                            coroutineScope.launch {
                                pagerState.animateScrollToPage(index)
                            }
                        },
                    )
                }
            }

            HorizontalPager(
                count = categories.size,
                state = pagerState
            ) { page ->
                products[categories[page].key]?.let {
                    ProductByCategory(
                        product = it,
                        onClickProduct = onClickProduct,
                        onClickFavorite = viewModel::favoriteStateChange
                    )
                }
            }
        }
    }
}