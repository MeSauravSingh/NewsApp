package com.example.newsapp.repository

import com.example.newsapp.network.NewsApi
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class UserRepository @Inject constructor(
    private val api: NewsApi,
) : BaseRepository() {

    suspend fun getNews() = safeApiCall {
        api.getNews("Apple","2025-01-08","popularity","3e68509623994b0cbbc58a15486d5c14")
    }


}