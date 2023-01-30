package com.example.movies.retrofit

import com.example.movies.retrofit.pojo.Movie
import com.example.movies.retrofit.pojo.MoviesResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {
    @GET("discover/movie?")
    fun getPopularMovies(
        @Query("api_key") api_key: String,
        //My (dev's) key. Will always be:
        //api_key=1af3cebe6ba136777ed3c08d01ec7484

        @Query("page") page: Int,
        //number of pages
        //1 --> enough for the beginning, more --> for adapter data update

        @Query("sort_by") sort_by: String,
        //to sort by the option passed
        //popularity.desc --> to sort by popularity descending

        @Query("vote_count.gte") vote_count_gte: Int,
        //means vote count over the passed Int:
        //20000 --> enough for the MOST popular movies

        @Query("vote_average.gte") vote_average_gte: Int
        //the grade goes from 1 to 10 if ascending
        //7 --> have high rating
    ) : Call<MoviesResponse>

    /*
    @GET("id")
    fun getId()

    @GET("title")
    fun getTitle()

    @GET("poster_path")
    fun getPoster()

    @GET("overview")
    fun getDescription()

    @GET("release_date")
    fun getYear()// String in format: 1999-12-31

    @GET("vote_average")
    fun getRating()
    */
}