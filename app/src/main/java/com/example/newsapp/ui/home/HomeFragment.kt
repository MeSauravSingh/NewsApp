package com.example.newsapp.ui.home

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.newsapp.R
import com.example.newsapp.adapter.NewsAdapter
import com.example.newsapp.data.Article
import com.example.newsapp.databinding.FragmentHomeBinding
import com.example.newsapp.network.Resource
import com.example.newsapp.ui.article.ArticleActivity
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeFragment:Fragment(R.layout.fragment_home) {

    private lateinit var binding: FragmentHomeBinding
    private val viewModel : HomeViewModel by viewModels()
    private val newsList = mutableListOf<Article>()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentHomeBinding.bind(view)

        binding.apply {

            val newsAdapter = NewsAdapter()

            rvNews.apply {
                val llm = LinearLayoutManager(requireContext())
                layoutManager = llm
                adapter = newsAdapter
            }


            viewModel.news.observe(viewLifecycleOwner){
                when(it){
                    is Resource.Success -> {
                        Log.d("HomeFragment", it.value.articles.toString())
                        newsList.clear()
                        newsList.addAll(it.value.articles)
                        newsAdapter.submitList(newsList)
                    }
                    is Resource.Loading -> {}
                    is Resource.Failure -> {

                    }
                }
            }

            newsAdapter.onItemClick = {
                val intent = Intent(requireActivity(),ArticleActivity::class.java)
                intent.putExtra("url",it.url)
                startActivity(intent)
            }

        }





    }
}