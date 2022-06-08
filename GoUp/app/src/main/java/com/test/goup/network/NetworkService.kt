package com.test.goup.network

import com.test.goup.model.Serie
import retrofit2.Call
import retrofit2.http.GET

interface NetworkService {

    @GET("/got.json")
    fun getData(): Call<Serie>

}