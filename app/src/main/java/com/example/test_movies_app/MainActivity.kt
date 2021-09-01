package com.example.test_movies_app

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.databinding.DataBindingUtil
import com.example.test_movies_app.adapter.MovieAdapter
import com.example.test_movies_app.databinding.ActivityMainBinding
import com.example.test_movies_app.viewModel.MainViewModel

class MainActivity : AppCompatActivity() {

    lateinit var binding : ActivityMainBinding
    val viewModel: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        binding.viewModel = viewModel
        binding.lifecycleOwner = this

        val adapter = MovieAdapter(mutableListOf(), viewModel)
        binding.recyclerViewMovies.adapter = adapter

    }
}