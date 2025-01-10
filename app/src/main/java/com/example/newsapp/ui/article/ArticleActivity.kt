package com.example.newsapp.ui.article

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.newsapp.databinding.ActivityArticleBinding
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class ArticleActivity:AppCompatActivity(){

    private lateinit var binding : ActivityArticleBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityArticleBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val url = intent.getStringExtra("url")?:""

        binding.apply {
            webView.settings.javaScriptEnabled = true // Enable JavaScript if needed
            webView.loadUrl(url)
            ivBack.setOnClickListener {
                finish()
            }
        }


    }
}