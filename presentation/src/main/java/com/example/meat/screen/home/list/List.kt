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
import com.example.meat.domain.model.Category
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
    viewModel.getProduct()

    val coroutineScope = rememberCoroutineScope()
    val products by viewModel.product.collectAsState()
    val pagerState = rememberPagerState()
    var categoryNames: List<String> by remember { mutableStateOf(emptyList()) }

    LaunchedEffect(products) {
        categoryNames = products.keys.toList()
    }

    if (products.isNotEmpty()) {
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
                categoryNames.forEachIndexed { index, categoryName ->
                    Tab(
                        text = { Text(text = categoryName) },
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
                count = categoryNames.size,
                state = pagerState
            ) { page ->
                products[categoryNames[page]]?.let {
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