package com.example.news.data.network

import com.example.news.News
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface NewsApi {
    @GET("everything")
    fun getNews(
        @Query("q") keyWord: String = "genshin",
        @Query("key")key:String = "961c3285ffc644448bf40948cab27c56",
        @Query("pageSize")pageSize:Int = 9
    ):Call<News>
}