package com.example.meat.screen.home

import androidx.compose.material.Text
import androidx.compose.runtime.Composable

@Composable
fun Home(
    navigateToDetail: (name: String) -> Unit
) {
    Text("Home")
}