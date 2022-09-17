package com.example.meat.screen.home

import androidx.compose.foundation.layout.size
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.meat.drawable.DrawableResources
import com.example.meat.screen.home.favorite.Favorite
import com.example.meat.screen.home.list.List

@Composable
fun Home(
    navigateToDetail: (name: String) -> Unit
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
        when(currentTab) {
            HomeTabs.List -> {
                List()
            }
            HomeTabs.Favorite -> {
                Favorite()
            }
        }
    }
}

enum class HomeTabs(val drawable: DrawableResources) {
    List(DrawableResources.List), Favorite(DrawableResources.OutlinedHeart)
}