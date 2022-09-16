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
import com.example.meat.screen.home.list.category.ProductByCategory
import com.google.accompanist.pager.*
import kotlinx.coroutines.launch

@OptIn(ExperimentalPagerApi::class)
@Composable
fun Product(
    viewModel: ProductViewModel = hiltViewModel()
) {
    viewModel.getCategory()
    viewModel.getProduct()

    val coroutineScope = rememberCoroutineScope()
    val category by viewModel.category.collectAsState()
    val product by viewModel.product.collectAsState()
    val pagerState = rememberPagerState()

    if (category.isNotEmpty()) {
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
                category.forEachIndexed { index, title ->
                    Tab(
                        text = { Text(text = title.name) },
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
                count = category.size,
                state = pagerState
            ) { page ->
                ProductByCategory(product = product[page])
            }
        }
    }
}