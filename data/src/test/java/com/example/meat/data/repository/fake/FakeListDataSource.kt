package com.example.meat.data.repository.fake

import com.example.meat.data.datasource.ListDataSource
import com.example.meat.domain.model.Category
import com.example.meat.domain.model.Product
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class FakeListDataSource : ListDataSource {
    override fun getCategory(): Flow<List<Category>> = flow {
        emit(
            listOf(
                Category("pork", "돼지", 0),
                Category("beef", "소", 1),
                Category("chicken", "닭", 2)
            )
        )
    }

    override fun getProductByCategory(categoryKey: String): Flow<List<Product>> = flow {
        emit(
            listOf(
                Product(
                    "pork01",
                    "pork",
                    "삼겹살",
                    19800,
                    "https://android-test.yookgak.com/static/JeongyookgakLogo.png",
                    0
                ),

                Product(
                    "pork02",
                    "pork",
                    "목살",
                    18600,
                    "https://android-test.yookgak.com/static/JeongyookgakLogo.png",
                    1
                ),
                Product(
                    "pork03",
                    "pork",
                    "항정살",
                    19800,
                    "https://android-test.yookgak.com/static/JeongyookgakLogo.png",
                    2
                ),
                Product(
                    "pork04",
                    "pork",
                    "등갈비",
                    19800,
                    "https://android-test.yookgak.com/static/JeongyookgakLogo.png",
                    3
                )
            )
        )
    }
}