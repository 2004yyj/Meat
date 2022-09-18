package com.example.meat.screen.detail

import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Icon
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.ripple.rememberRipple
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.semantics.Role
import androidx.compose.ui.unit.dp
import com.example.meat.drawable.DrawableResources

@Composable
fun Detail(
    key: String,
    name: String,
    price: Int,
    onNavigationClick: () -> Unit
) {
    Scaffold(
        topBar = {
            TopAppBar(
                navigationIcon = {
                    Icon(
                        contentDescription = "backButton",
                        painter = painterResource(DrawableResources.ArrowBack.id),
                        modifier = Modifier
                            .padding(horizontal = 10.dp)
                            .clickable(
                                role = Role.Button,
                                interactionSource = remember { MutableInteractionSource() },
                                indication = rememberRipple(
                                    bounded = false,
                                    radius = 24.dp,
                                ),
                                onClick = onNavigationClick
                            ),
                    )
                },
                title = {
                    Text(text = "상품상세")
                }
            )
        }
    ) {
    }
}