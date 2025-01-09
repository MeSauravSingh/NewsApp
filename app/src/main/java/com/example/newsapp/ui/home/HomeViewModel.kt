package com.example.newsapp.ui.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.newsapp.data.NewsResponse
import com.example.newsapp.network.Resource
import com.example.newsapp.repository.UserRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val repository: UserRepository,
) : ViewModel() {


    private val _news: MutableLiveData<Resource<NewsResponse>> = MutableLiveData()
    val news: LiveData<Resource<NewsResponse>>
        get() = _news

    init {
        this.getNews()
    }

    fun getNews() = viewModelScope.launch {
        _news.value = Resource.Loading
        _news.value = repository.getNews()
    }

}