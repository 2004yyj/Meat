package com.example.meat.screen.home.list

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.ScrollableTabRow
import androidx.compose.material.Tab
import androidx.compose.material.TabRowDefaults
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.meat.screen.home.list.key.ProductByKey
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.HorizontalPager
import com.google.accompanist.pager.pagerTabIndicatorOffset
import com.google.accompanist.pager.rememberPagerState
import kotlinx.coroutines.launch

@OptIn(ExperimentalPagerApi::class)
@Composable
fun Product(
    viewModel: ProductViewModel = hiltViewModel()
) {
    viewModel.getCategory()
    val coroutineScope = rememberCoroutineScope()
    val category by viewModel.category.collectAsState()

    Column(modifier = Modifier.fillMaxSize()) {
        val pagerState = rememberPagerState()
        if (category.isNotEmpty()) {
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
                state = pagerState,
            ) { page ->
                ProductByKey(categoryKey = category[page].key)
            }
        }
    }
}