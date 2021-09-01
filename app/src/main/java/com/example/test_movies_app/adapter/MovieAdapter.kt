package com.example.test_movies_app.adapter

import com.example.test_movies_app.R
import com.example.test_movies_app.moviesModel.Result

class MovieAdapter ( items: List<Result>,
                     var listener: MovieInteractionListener,
) : BaseAdapter<Result>(items,listener) {

    override val layoutId: Int = R.layout.item_movie

}



