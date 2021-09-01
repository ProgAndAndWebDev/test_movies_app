package com.example.test_movies_app.repository

import com.example.test_movies_app.Status
import com.example.test_movies_app.moviesModel.Constants.KEY_API
import com.example.test_movies_app.moviesModel.PopularMoviesResponse
import com.example.test_movies_app.networking.API
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.Response

class MoviesRespository {
    fun getMoviesPopular()
    : Flow<Status<PopularMoviesResponse?>> =
        wrampWithFlow {API.apiService.getMovieList(KEY_API) }

    fun <T> wrampWithFlow(function: suspend () -> Response<T> )
            : Flow<Status<T?>>
        = flow {
            emit(Status.Loading)
            try{
                val result = function()
                if (result.isSuccessful)
                    emit(Status.Success(result.body()))
                else
                    emit(Status.Error(result.message()))
            } catch (e:Exception){
                emit(Status.Error(e.message.toString()))
            }
        }

}
