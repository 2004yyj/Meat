package com.example.meat.data.remote

import com.example.meat.data.entity.CategoryData
import com.example.meat.data.entity.ListData
import com.example.meat.data.entity.ProductData
import com.example.meat.data.remote.service.ListService
import junit.framework.Assert.assertEquals
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runTest
import okhttp3.mockwebserver.MockResponse
import okhttp3.mockwebserver.MockWebServer
import org.junit.Before
import org.junit.Test
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.io.File

@OptIn(ExperimentalCoroutinesApi::class)
class ListServiceTest {
    private lateinit var mockWebServer: MockWebServer
    private lateinit var listService: ListService

    @Before
    fun before() {
        mockWebServer = MockWebServer()
        listService = Retrofit.Builder()
            .baseUrl(mockWebServer.url(""))
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(ListService::class.java)
    }

    @Test
    fun 리스트_가져오기() = runTest {
        val jsonFile = File("src/test/java/com/example/meat/data/remote/resource/list.json").readText()
        val response = MockResponse().setBody(jsonFile)
        mockWebServer.enqueue(response)

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
        val actual = listService.getList().body()
        assertEquals(expected, actual)
    }
}