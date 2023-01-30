package com.example.movies.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.movies.databinding.MovieRecyclerItemBinding
import com.example.movies.retrofit.pojo.Movie
import com.example.movies.retrofit.pojo.MoviesResponse

class MainActivityAdapter(
    private val movieClickListener: OnMovieClickListener
) : RecyclerView.Adapter<MainActivityAdapter.MovieViewHolder>() {
    var movies = emptyList<Movie>()

    fun setMovieList(movies: List<Movie>) {
//        this.movies = movies
        this.movies = movies.toMutableList()
        notifyDataSetChanged()
    }

    inner class MovieViewHolder(
        private val itemBinding: MovieRecyclerItemBinding
    ) : RecyclerView.ViewHolder(itemBinding.root) {
        fun bind(
            holder: MovieViewHolder,
            position: Int
        ) {
            val movie: Movie = movies[position]
//            holder.itemBinding.tvItemName.text = movie.
//            val imageUrl = movie.

//            Glide.with(holder.itemView.context).load(movie.imageUrl).into(holder.binding.imageview)
            Glide.with(itemBinding.root.context)
                .load(movie.)
                .into(holder.itemBinding.ivItemPoster)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder =
        MovieViewHolder(
            MovieRecyclerItemBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )

    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
        holder.bind(holder, position)
    }

    override fun getItemCount(): Int = movies.size

    interface OnMovieClickListener {
        fun onMovieClick(adapterPosition: Int)
    }
}