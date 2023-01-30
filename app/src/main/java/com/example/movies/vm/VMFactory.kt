package com.example.movies.vm

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.movies.MoviesRepository

class VMFactory(private val repository: MoviesRepository) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return if (modelClass.isAssignableFrom(MoviesVM::class.java)) {
            @Suppress("UNCHECKED_CAST")
            MoviesVM(this.repository) as T
        } /*else if (modelClass.isAssignableFrom(TOD0("Some other VM"))) {
            @Suppress("UNCHECKED_CAST")
            TOD0("Some other VM") as T
        }*/ else {
            super.create(modelClass)
        }
    }
}