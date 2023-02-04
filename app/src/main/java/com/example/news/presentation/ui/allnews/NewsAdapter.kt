package com.example.news.presentation.ui.allnews

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.example.news.Articles
import com.example.news.databinding.NewsItemBinding

class NewsAdapter(val list: ArrayList<Articles>): RecyclerView.Adapter<NewsAdapter.NewsViewHolder>() {

    inner class NewsViewHolder(val binding: NewsItemBinding): RecyclerView.ViewHolder(binding.root){
        fun onBind(articles: Articles){
            with(binding){
                tvNewsAuthor.setText(articles.author)
                tvNewsDate.setText(articles.publishedAt)
                imgNews.load(articles.urlToImage)
                tvNewsTitle.setText(articles.title)
                tvNewsDescription.setText(articles.description)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NewsViewHolder {
        return NewsViewHolder(
            NewsItemBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: NewsViewHolder, position: Int) {
        holder.onBind(list[position])
    }

    override fun getItemCount() = list.size
}