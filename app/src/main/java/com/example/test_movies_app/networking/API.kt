package com.example.test_movies_app.networking

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object API {
    private const val BASE_URL = "https://api.themoviedb.org/"

    private val retrofit = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    val apiService = retrofit.create(MoviesService::class.java)
}