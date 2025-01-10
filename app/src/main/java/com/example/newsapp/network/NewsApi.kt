package com.example.newsapp.network

import com.example.newsapp.data.NewsResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface NewsApi {
    @GET("top-headlines")
    suspend fun getNews(
        @Query("country") query: String,
        @Query("apiKey") apiKey: String
    ): NewsResponse
}