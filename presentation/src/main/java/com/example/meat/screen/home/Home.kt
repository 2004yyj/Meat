package com.example.meat.screen.home

import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import com.example.meat.drawable.DrawableResources

@Composable
fun Home(
    navigateToDetail: (name: String) -> Unit
) {
    Text("Home")
}

enum class HomeTabs(val drawable: DrawableResources) {
    List(DrawableResources.List), Favorite(DrawableResources.OutlinedHeart)
}