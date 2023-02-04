package com.example.news.presentation.ui.allnews

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.news.App
import com.example.news.Articles
import com.example.news.News
import com.example.news.databinding.FragmentAllNewsBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class AllNewsFragment : Fragment() {

    private val data = arrayListOf<Articles>()
    private lateinit var binding: FragmentAllNewsBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentAllNewsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        App.api.getNews().enqueue(object : Callback<News>{
            override fun onResponse(call: Call<News>, response: Response<News>) {
                response.body()?.articles?.let {
                val adapter = NewsAdapter(it as ArrayList<Articles>)
                    binding.newsRv.adapter = adapter
                }
            }

            override fun onFailure(call: Call<News>, t: Throwable) {
                Log.e("ololo", "onFailure: ${t.message}")
            }

        })

//        val adapter = NewsAdapter(data)
//        binding.newsRv.adapter = adapter

    }

}