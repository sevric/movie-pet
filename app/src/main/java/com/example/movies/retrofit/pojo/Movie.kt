package com.example.movies.retrofit.pojo

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

//@Entity(tableName = "movieList")
data class Movie(
    @SerializedName("id")
//    @PrimaryKey
    private val id: Int,//id

    @SerializedName("title")
    private val title: String,//title

    @SerializedName("poster_path")
    private val poster: String,//poster_path

    @SerializedName("overview")
    private val description: String,//overview

    @SerializedName("release_date")
    private val year: String,//release_date="1999-10-15"

    @SerializedName("vote_average")
    private val rating: Int//vote_average
)