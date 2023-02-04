package com.example.news.data.network

import com.example.news.News
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface NewsApi {
    @GET("everything")
    fun getNews(
        @Query("q") keyWord: String = "genshin",
        @Query("apiKey")apiKey:String = "961c3285ffc644448bf40948cab27c56"
    ):Call<News>


    @GET("top-headlines")
    fun getTopHeadLines(
        @Query("country") country: String,
        @Query("apiKey")apiKey:String = "961c3285ffc644448bf40948cab27c56"
    ):Call<News>
}