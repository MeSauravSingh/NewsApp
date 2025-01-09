package com.example.newsapp.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.newsapp.data.Article
import com.example.newsapp.databinding.RowNewsBinding
import com.example.newsapp.setGlide

class NewsAdapter : ListAdapter<Article, NewsAdapter.ViewHolder>(DiffCallBack()) {

    inner class ViewHolder(private val binding: RowNewsBinding) :
        RecyclerView.ViewHolder(binding.root) {

        init {

            binding.apply {



            }
        }


        fun bind(article: Article) {
            binding.apply {
                ivImageNews.setGlide(itemView.context,article.urlToImage?:"")
                tvTitleNews.text = article.title
                tvDescNews.text = article.description


            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = RowNewsBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val currentItem = getItem(position)
        holder.bind(currentItem)
    }

    class DiffCallBack : DiffUtil.ItemCallback<Article>() {
        override fun areItemsTheSame(oldItem: Article, newItem: Article): Boolean {
            return oldItem.content == newItem.content
        }

        override fun areContentsTheSame(oldItem: Article, newItem: Article): Boolean {
            return oldItem == newItem
        }
    }
    override fun getItemId(position: Int): Long {
        return position.toLong()
    }
    override fun getItemViewType(position: Int): Int {
        return position
    }

}