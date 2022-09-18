package com.example.meat.screen.detail

import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Icon
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.ripple.rememberRipple
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.VerticalAlignmentLine
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.semantics.Role
import androidx.compose.ui.unit.dp
import com.example.meat.components.checkbox.HeartCheckbox
import com.example.meat.drawable.DrawableResources

@Composable
fun Detail(
    key: String,
    name: String,
    price: Int,
    onNavigationClick: () -> Unit,
) {
    var checked by remember { mutableStateOf(false) }

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
        Column(
            modifier = Modifier
                .padding(it)
                .fillMaxSize()
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(10.dp)
            ) {
                Text(
                    text = name,
                    modifier = Modifier
                        .align(Alignment.CenterHorizontally)
                )
                Text(
                    text = "${price}원",
                    modifier = Modifier
                        .align(Alignment.CenterHorizontally)
                )
                HeartCheckbox(
                    checked = checked,
                    onCheckedChange = {
                        checked = it
                    },
                    modifier = Modifier
                        .padding(top = 10.dp)
                        .align(Alignment.CenterHorizontally)
                )
            }
        }
    }
}