package com.example.meat.data.datasource

import com.example.meat.data.datasource.fake.FakeListService
import com.example.meat.data.remote.datasource.ListDataSourceImpl
import com.example.meat.data.remote.service.ListService
import com.example.meat.domain.model.Category
import com.example.meat.domain.model.Product
import com.example.meat.domain.model.ListModel
import junit.framework.Assert.assertEquals
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.launch
import kotlinx.coroutines.test.UnconfinedTestDispatcher
import kotlinx.coroutines.test.runTest
import org.junit.Before
import org.junit.Test

@OptIn(ExperimentalCoroutinesApi::class)
class ListDataSourceTest {
    private lateinit var listService: ListService
    private lateinit var listDataSource: ListDataSource

    @Before
    fun before() {
        listService = FakeListService()
        listDataSource = ListDataSourceImpl(listService)
    }

    @Test
    fun 카테고리_가져오기() = runTest {
        val expected = listOf(
            Category("pork", "돼지", 0),
            Category("beef", "소", 1),
            Category("chicken", "닭", 2)
        )
        var actual: List<Category>? = null
        val testJob = launch(UnconfinedTestDispatcher()) {
            listDataSource.getCategory().collect {
                actual = it
            }
        }
        assertEquals(expected, actual)
        testJob.cancel()
    }

    @Test
    fun 리스트_가져오기() = runTest {
        val expected = ListModel(
            categories = listOf(
                Category("pork", "돼지", 0),
                Category("beef", "소", 1),
                Category("chicken", "닭", 2)
            ),
            productions = listOf(
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

        var actual: ListModel? = null
        val testJob = launch(UnconfinedTestDispatcher()) {
            listDataSource.getList().collect {
                actual = it
            }
        }
        assertEquals(expected, actual)
        testJob.cancel()
    }
}