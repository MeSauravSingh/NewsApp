package com.example.newsapp.di

import com.example.newsapp.network.NewsApi
import com.example.newsapp.network.RemoteDataSource
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideNewsApi(
        remoteDataSource: RemoteDataSource
    ): NewsApi {
        return remoteDataSource.buildApi(NewsApi::class.java)
    }

}