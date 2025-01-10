package com.example.newsapp.repository

import com.example.newsapp.Constants
import com.example.newsapp.R
import com.example.newsapp.network.NewsApi
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class UserRepository @Inject constructor(
    private val api: NewsApi,
) : BaseRepository() {


    suspend fun getNews() = safeApiCall {
        api.getNews("us",  Constants.API_KEY)
    }


}