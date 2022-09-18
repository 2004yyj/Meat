package com.example.meat.data.remote.base

import retrofit2.Response

abstract class BaseRemote {
    fun <T> getResponse(response: Response<T>): T {
        checkError(response)
        return response.body()!!
    }

    private fun <T> checkError(response: Response<T>) {
        if (!response.isSuccessful) {
            throw Throwable(response.code().toString())
        }
    }
}