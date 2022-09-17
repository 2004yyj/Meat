package com.example.meat.data.repository

import androidx.paging.AsyncPagingDataDiffer
import com.example.meat.data.datasource.FavoriteDataSource
import com.example.meat.data.local.TestCallback
import com.example.meat.data.local.TestUpdateCallback
import com.example.meat.data.repository.fake.FakeFavoriteDataSource
import com.example.meat.domain.model.Product
import com.example.meat.domain.repository.FavoriteRepository
import junit.framework.Assert.assertEquals
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.launch
import kotlinx.coroutines.test.UnconfinedTestDispatcher
import kotlinx.coroutines.test.runTest
import kotlinx.coroutines.test.setMain
import org.junit.Before
import org.junit.Test

@OptIn(ExperimentalCoroutinesApi::class)
class FavoriteRepositoryTest {
    private lateinit var favoriteDataSource: FavoriteDataSource
    private lateinit var favoriteRepository: FavoriteRepository

    @Before
    fun before() {
        favoriteDataSource = FakeFavoriteDataSource()
        favoriteRepository = FavoriteRepositoryImpl(favoriteDataSource)
    }

    @Test
    fun 좋아요_추가하기() = runTest {
        val expected = 3L
        val actual =
            favoriteRepository.insertFavorite(
                Product(
                    "pork01",
                    "pork",
                    "삼겹살",
                    19800,
                    "https://android-test.yookgak.com/static/JeongyookgakLogo.png",
                    0
                )
            )
        assertEquals(expected, actual)
    }

    @Test
    fun 좋아요_추가_및_해당_아이템_존재_여부_확인() = runTest {
        favoriteRepository.insertFavorite(
            Product(
                "pork01",
                "pork",
                "삼겹살",
                19800,
                "https://android-test.yookgak.com/static/JeongyookgakLogo.png",
                0
            )
        )

        val expected = true
        val actual = favoriteRepository.isExistsFavorite("pork01")

        assertEquals(expected, actual)
    }

    @Test
    fun 좋아요_삭제_및_해당_아이템_존재_여부_확인() = runTest {
        favoriteRepository.insertFavorite(
            Product(
                "pork03",
                "pork",
                "삼겹살",
                19800,
                "https://android-test.yookgak.com/static/JeongyookgakLogo.png",
                0
            )
        )
        favoriteRepository.deleteFavorite("pork03")

        val expected = false
        val actual = favoriteRepository.isExistsFavorite("pork03")

        assertEquals(expected, actual)
    }

    @Test
    fun 좋아요_페이징_리스트_가져오기() = runTest {
        Dispatchers.setMain(UnconfinedTestDispatcher())
        val differ = AsyncPagingDataDiffer(
            diffCallback = TestCallback<Product>(),
            updateCallback = TestUpdateCallback(),
            workerDispatcher = UnconfinedTestDispatcher()
        )

        val expected = listOf(
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
                19800,
                "https://android-test.yookgak.com/static/JeongyookgakLogo.png",
                0
            )
        )
        val actual: List<Product>?
        val testJob = launch(UnconfinedTestDispatcher()) {
            favoriteRepository.searchFavorite().collect {
                differ.submitData(it)
            }
        }
        actual = differ.snapshot().items

        assertEquals(expected, actual)
        testJob.cancel()
    }

    @Test
    fun 모든_좋아요_가져오기() = runTest {
        val expected = listOf(
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
                19800,
                "https://android-test.yookgak.com/static/JeongyookgakLogo.png",
                0
            )
        )
        var actual: List<Product>? = null
        val testJob = launch(UnconfinedTestDispatcher()) {
            favoriteRepository.getAllFavorite().collect {
                actual = it
            }
        }

        assertEquals(expected, actual)
        testJob.cancel()
    }
}