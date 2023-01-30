package com.example.movies.retrofit.pojo

import com.google.gson.annotations.SerializedName

data class MoviesResponse (
    @SerializedName("results")
    val movies: List<Movie>
)