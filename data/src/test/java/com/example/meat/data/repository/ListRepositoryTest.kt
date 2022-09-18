package com.example.meat.data.repository

import com.example.meat.domain.model.ListModel
import com.example.meat.data.repository.fake.FakeListDataSource
import com.example.meat.domain.model.Category
import com.example.meat.domain.model.Product
import com.example.meat.domain.repository.ListRepository
import junit.framework.Assert
import junit.framework.Assert.assertEquals
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.launch
import kotlinx.coroutines.test.UnconfinedTestDispatcher
import kotlinx.coroutines.test.runTest
import org.junit.Before
import org.junit.Test

@OptIn(ExperimentalCoroutinesApi::class)
class ListRepositoryTest {
    private lateinit var listDataSource: FakeListDataSource
    private lateinit var listRepository: ListRepository

    @Before
    fun before() {
        listDataSource = FakeListDataSource()
        listRepository = ListRepositoryImpl(listDataSource)
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
            listRepository.getList().collect {
                actual = it
            }
        }
        assertEquals(expected, actual)
        testJob.cancel()
    }
}