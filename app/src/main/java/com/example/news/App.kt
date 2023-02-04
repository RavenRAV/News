package com.example.news

import android.app.Application
import com.example.news.data.network.NewsApi
import com.example.news.data.network.RetrofitService

class App: Application() {

    companion object{
        lateinit var api: NewsApi
    }

    override fun onCreate() {
        super.onCreate()
        api = RetrofitService().getApi()
    }
}