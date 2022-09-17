package com.example.meat.data.local

import androidx.paging.PagingSource
import androidx.room.Room
import androidx.test.platform.app.InstrumentationRegistry
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.example.meat.data.entity.FavoriteData
import junit.framework.Assert.assertEquals
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runTest
import com.example.meat.data.local.dao.FavoriteDao
import com.example.meat.data.local.database.AppDatabase
import org.junit.After
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
@OptIn(ExperimentalCoroutinesApi::class)
class FavoriteDaoTest {
    private lateinit var database: AppDatabase
    private lateinit var favoriteDao: FavoriteDao

    @Before
    fun before() {
        val context = InstrumentationRegistry.getInstrumentation().targetContext
        database =
            Room.inMemoryDatabaseBuilder(context, AppDatabase::class.java)
                .build()
        favoriteDao = database.favoriteDao()
    }

    @After
    fun after() {
        database.close()
    }

    @Test
    fun 좋아요_추가하기() = runTest {
        val expected = listOf(1L)
        val actual =
            favoriteDao.insertFavorite(
                FavoriteData(
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
        favoriteDao.insertFavorite(
            FavoriteData(
                "pork01",
                "pork",
                "삼겹살",
                19800,
                "https://android-test.yookgak.com/static/JeongyookgakLogo.png",
                0
            )
        )

        val expected = true
        val actual = favoriteDao.isExistsFavorite("pork01")

        assertEquals(expected, actual)
    }

    @Test
    fun 좋아요_삭제_및_해당_아이템_존재_여부_확인() = runTest {
        favoriteDao.insertFavorite(
            FavoriteData(
                "pork01",
                "pork",
                "삼겹살",
                19800,
                "https://android-test.yookgak.com/static/JeongyookgakLogo.png",
                0
            )
        )
        favoriteDao.deleteFavorite("pork01")

        val expected = false
        val actual = favoriteDao.isExistsFavorite("pork01")

        assertEquals(expected, actual)
    }

    @Test
    fun 좋아요_추가_및_리스트_가져오기() = runTest {
        val data1 = FavoriteData(
            "pork01",
            "pork",
            "삼겹살",
            19800,
            "https://android-test.yookgak.com/static/JeongyookgakLogo.png",
            0
        )
        val data2 = FavoriteData(
            "pork02",
            "pork",
            "목살",
            19800,
            "https://android-test.yookgak.com/static/JeongyookgakLogo.png",
            0
        )
        favoriteDao.insertFavorite(data1, data2)

        val expected = PagingSource.LoadResult.Page(
            data = listOf(data1, data2),
            prevKey = null,
            nextKey = null,
            itemsAfter = 0,
            itemsBefore = 0
        )
        val actual =
            favoriteDao.searchFavorite().load(
                PagingSource.LoadParams.Refresh(
                    key = null,
                    loadSize = 2,
                    placeholdersEnabled = false
                )
            )
        assertEquals(expected, actual)
    }
}