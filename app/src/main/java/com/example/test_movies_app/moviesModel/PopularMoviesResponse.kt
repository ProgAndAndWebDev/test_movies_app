package com.example.test_movies_app.moviesModel



import com.google.gson.annotations.SerializedName


data class PopularMoviesResponse(
    @SerializedName("page")
    val page: Int? = null,
    @SerializedName("results")
    val results: List<Result>? = null,
    @SerializedName("total_pages")
    val totalPages: Int? = null,
    @SerializedName("total_results")
    val totalResults: Int? = null
)