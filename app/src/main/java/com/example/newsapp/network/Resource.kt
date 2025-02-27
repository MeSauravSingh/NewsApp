package com.example.newsapp.network

import okhttp3.ResponseBody

sealed class Resource<out T> {
    data class Success<out T>(val value: T) : Resource<T>()
    data class Failure(
        val isNetworkError: Boolean,
        val errorCode: Int?,
        val message: String?,
        val errorBody: ResponseBody?
    ): Resource<Nothing>()
    object Loading : Resource<Nothing>()
}