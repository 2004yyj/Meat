package com.example.meat.screen.home.item

import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.example.meat.domain.model.Product

@Composable
fun ProductItem(
    modifier: Modifier = Modifier,
    product: Product,
    onClick: (Product) -> Unit = {},
) {
    Row(
        modifier = modifier.fillMaxWidth()
    ) {
        AsyncImage(
            modifier = Modifier.size(80.dp),
            model = product.thumbnail,
            contentDescription = "ProductThumbnail"
        )

        Box(modifier = modifier.weight(1f)) {
            Text(
                modifier = Modifier.align(Alignment.TopStart),
                text = product.name
            )
        }
    }
}

@Preview
@Composable
fun ProductItemPreview() {
    ProductItem(
        product = Product(
        "pork1",
        "pork",
        "돼지고기",
        24000,
        "https://android-test.yookgak.com/static/JeongyookgakLogo.png",
        0
        )
    )
}