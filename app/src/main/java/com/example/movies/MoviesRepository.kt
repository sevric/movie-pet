package com.example.movies

import androidx.lifecycle.MutableLiveData
import com.example.movies.retrofit.ApiService
import com.example.movies.retrofit.pojo.Movie
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MoviesRepository(
//    private val movieDao: Dao
    private var apiService: ApiService
) {
    private val popularMoviesLiveData = MutableLiveData<List<Movie>>()

    companion object {
        private const val BASE_URL = "https://api.themoviedb.org/3/"
        private const val RETROFIT_LOG_TAG = "RETROFIT ERROR"
    }

    init {
        apiService = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(ApiService::class.java)
    }

    fun getPopularMoviesFromApi(
        api_key: String,
        page: Int,
        sort_by: String,
        vote_count_gte: Int,
        vote_average_gte: Int
    ) = apiService
            .getPopularMovies(
                api_key,
                page,
                sort_by,
                vote_count_gte,
                vote_average_gte
            )/*
            .enqueue(
                object : Callback<MoviesResponse> {
                    override fun onResponse(
                        call: Call<MoviesResponse>,
                        response: Response<MoviesResponse>
                    ) {
                        if (response.body() != null) {
                            popularMoviesLiveData.value = response.body()!!.movies
                        }
                    }

                    override fun onFailure(call: Call<MoviesResponse>, t: Throwable) {
                        Log.d(
                            RETROFIT_LOG_TAG,
                            "Error while Retrofit attempted to connect the API"
                        )
                    }
                }
            )
            */
}