package com.example.meat.screen.home

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.meat.domain.model.Product
import com.example.meat.drawable.DrawableResources
import com.example.meat.screen.home.favorite.Favorite
import com.example.meat.screen.home.list.List

@Composable
fun Home(
    navigateToDetail: (Product) -> Unit
) {
    var currentTab by remember { mutableStateOf(HomeTabs.List) }

    Scaffold(
        bottomBar = {
            BottomNavigation {
                HomeTabs.values().forEach {
                    BottomNavigationItem(
                        selected = currentTab == it,
                        onClick = { currentTab = it },
                        icon = {
                            Icon(
                                modifier = Modifier.size(24.dp),
                                painter = painterResource(id = it.drawable.id),
                                contentDescription = "itemIcon"
                            )
                        },
                        label = { Text(it.name) }
                    )
                }
            }
        }
    ) {
        Box (modifier = Modifier.padding(it)) {
            when (currentTab) {
                HomeTabs.List -> {
                    List(onClickProduct = navigateToDetail)
                }
                HomeTabs.Favorite -> {
                    Favorite(onClickProduct = navigateToDetail)
                }
            }
        }
    }
}

enum class HomeTabs(val drawable: DrawableResources) {
    List(DrawableResources.List), Favorite(DrawableResources.OutlinedHeart)
}