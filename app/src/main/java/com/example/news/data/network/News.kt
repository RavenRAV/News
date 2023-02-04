package com.example.news

data class News(
    val articles: List<Articles>
)

data class Articles(
    val author: String,
    val title: String,
    val description: String,
    val urlToImage: String,
    val publishedAt: String,

)