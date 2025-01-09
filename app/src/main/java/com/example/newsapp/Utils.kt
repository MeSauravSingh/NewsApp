package com.example.newsapp

import android.content.Context
import android.widget.ImageView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions

fun ImageView.setGlide(context: Context, image: String){
    Glide.with(context)
        .load(image)
        .apply(RequestOptions().placeholder(R.drawable.news_placeholder))
        .into(this)
}