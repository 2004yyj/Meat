package com.example.meat.screen.home.item

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.example.meat.components.checkbox.HeartCheckbox
import com.example.meat.domain.model.Product
import com.example.meat.theme.Typography

@Composable
fun ProductItem(
    modifier: Modifier = Modifier,
    product: Product,
    onClick: (Product) -> Unit = {},
    onClickFavorite: (Product) -> Unit = {}
) {
    var checked by remember { mutableStateOf(product.favorite) }

    LaunchedEffect(product) {
        // 리스트 아이템 변경 시 Product의 데이터만 변경되고
        // State는 변경된 데이터가 적용되지 않아서
        // 내부 데이터가 변화할 때 State도 업데이트 하기 위한 코드
        checked = product.favorite
    }

    Row(
        modifier = modifier
            .clickable { onClick(product) }
            .fillMaxWidth()
            .height(ItemSize)
    ) {
        AsyncImage(
            modifier = Modifier.size(ItemSize),
            model = product.thumbnail,
            contentDescription = "ProductThumbnail",
        )

        Box(
            modifier = Modifier
                .weight(1f)
                .fillMaxHeight()
                .padding(10.dp, 0.dp)
        ) {
            Column(modifier = Modifier.align(Alignment.CenterStart)) {
                Text(
                    text = product.name,
                    style = Typography.body1
                )
                Text(
                    text = "${product.price}원",
                    style = Typography.body2
                )
            }

            HeartCheckbox(
                modifier = Modifier.align(Alignment.CenterEnd),
                checked = checked,
                onCheckedChange = {
                    checked = it
                    onClickFavorite(product)
                },
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

private val ItemSize = 80.dp