package com.example.meat.data.remote.service

import com.example.meat.data.entity.ListData
import retrofit2.Response
import retrofit2.http.GET

interface ListService {
    @GET("/products")
    suspend fun getList(): Response<ListData>
}