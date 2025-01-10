package com.example.newsapp.ui.article

import androidx.lifecycle.ViewModel
import com.example.newsapp.repository.UserRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class ArticleViewModel @Inject constructor(
    private val repository: UserRepository,
) : ViewModel() {



}