package com.example.test_movies_app.viewModel


import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.example.test_movies_app.Status
import com.example.test_movies_app.adapter.MovieInteractionListener
import com.example.test_movies_app.repository.MoviesRespository
import com.example.test_movies_app.moviesModel.PopularMoviesResponse
import com.example.test_movies_app.moviesModel.Result

class MainViewModel : ViewModel() , MovieInteractionListener {

    private val repository = MoviesRespository()

    val popularMovies: LiveData<Status<PopularMoviesResponse?>>
        = repository.getMoviesPopular().asLiveData()
    

    override fun onClickMovie(movie: Result) {

    }

//    init {
//        getRandomJoke()
//    }
//
//    private fun getRandomJoke(){
//        viewModelScope.launch {
//            repository.getRandomJoke().collect {
//                Log.i("rrrrrrr",it.toString())
//                movies.postValue(it)
//            }
//        }
//    }

}