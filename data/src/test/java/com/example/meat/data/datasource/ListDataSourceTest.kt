package com.example.meat.data.datasource

import com.example.meat.data.datasource.fake.FakeListService
import com.example.meat.data.entity.CategoryData
import com.example.meat.data.entity.ListData
import com.example.meat.data.entity.ProductData
import com.example.meat.data.remote.datasource.ListDataSourceImpl
import com.example.meat.data.remote.service.ListService
import junit.framework.Assert.assertEquals
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.launch
import kotlinx.coroutines.test.UnconfinedTestDispatcher
import kotlinx.coroutines.test.runTest
import org.junit.Before
import org.junit.Test

class ListDataSourceTest {
    private lateinit var listService: ListService
    private lateinit var listDataSource: ListDataSource

    @Before
    fun before() {
        listService = FakeListService()
        listDataSource = ListDataSourceImpl(listService)
    }

    @OptIn(ExperimentalCoroutinesApi::class)
    @Test
    fun 리스트_가져오기() = runTest {
        val expected = ListData(
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
        var actual: ListData? = null
        val testJob = launch(UnconfinedTestDispatcher()) {
            listDataSource.getList().collect {
                actual = it
            }
        }
        assertEquals(expected, actual)
        testJob.cancel()
    }
}