package com.example.meat.data.datasource.fake

import com.example.meat.data.entity.CategoryData
import com.example.meat.data.entity.ListData
import com.example.meat.data.entity.ProductData
import com.example.meat.data.remote.service.ListService
import retrofit2.Response

class FakeListService : ListService {
    override suspend fun getList(): Response<ListData> {
        return Response.success(
            ListData(
                categories = listOf(
                    CategoryData("pork", "돼지", 0),
                    CategoryData("beef", "소", 1),
                    CategoryData("chicken", "닭", 2)
                ),
                productions = listOf(
                    ProductData(
                        "pork01",
                        "pork",
                        "삼겹살",
                        19800,
                        "https://android-test.yookgak.com/static/JeongyookgakLogo.png",
                        0
                    ),

                    ProductData(
                        "pork02",
                        "pork",
                        "목살",
                        18600,
                        "https://android-test.yookgak.com/static/JeongyookgakLogo.png",
                        1
                    ),
                    ProductData(
                        "pork03",
                        "pork",
                        "항정살",
                        19800,
                        "https://android-test.yookgak.com/static/JeongyookgakLogo.png",
                        2
                    ),
                    ProductData(
                        "pork04",
                        "pork",
                        "등갈비",
                        19800,
                        "https://android-test.yookgak.com/static/JeongyookgakLogo.png",
                        3
                    )
                )
            )
        )
    }
}