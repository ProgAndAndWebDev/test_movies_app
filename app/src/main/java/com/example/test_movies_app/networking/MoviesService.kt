package com.example.test_movies_app.networking

import com.example.test_movies_app.moviesModel.PopularMoviesResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface MoviesService {

    @GET("3/movie/popular")
    suspend fun getMovieList(
        @Query("api_key") apiKey: String,
    ): Response<PopularMoviesResponse>



}