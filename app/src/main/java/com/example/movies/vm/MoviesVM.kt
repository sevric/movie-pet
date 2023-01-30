package com.example.movies.vm

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.movies.MoviesRepository
import com.example.movies.retrofit.pojo.Movie
import com.example.movies.retrofit.pojo.MoviesResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MoviesVM(
    private val repository: MoviesRepository
) : ViewModel() {
    private val popularMoviesLiveData = MutableLiveData<List<Movie>>()

    companion object {
        const val RETROFIT_LOG_TAG = "RETROFIT ERROR"
    }

    fun getPopularMoviesFromApi(
        api_key: String,
        page: Int,
        sort_by: String,
        vote_count_gte: Int,
        vote_average_gte: Int
    ) {
        val response = repository.getPopularMoviesFromApi(
            api_key,
            page,
            sort_by,
            vote_count_gte,
            vote_average_gte
        ).enqueue(
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
        /*
        RetrofitInstance.apiService
            .getPopularMovies(
                api_key,
                page,
                sort_by,
                vote_count_gte,
                vote_average_gte
            )
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
                            "Error while Retrofit try to connect the API"
                        )
                    }
                }
            )
            */
    }

    fun observePopularMoviesFromApi(): LiveData<List<Movie>> {
        return popularMoviesLiveData
    }
}