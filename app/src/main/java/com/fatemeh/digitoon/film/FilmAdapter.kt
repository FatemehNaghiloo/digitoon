package com.fatemeh.digitoon.film

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.fatemeh.digitoon.databinding.ItemFilmBinding
import com.fatemeh.digitoon.model.Film
import com.fatemeh.digitoon.model.SearchItem
import com.squareup.picasso.Picasso

class FilmAdapter(
    var films: List<SearchItem>,
    private val onFilmClick: (String) -> Unit
) : RecyclerView.Adapter<FilmAdapter.FilmViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FilmViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ItemFilmBinding.inflate(inflater, parent, false)
        return FilmViewHolder(binding, onFilmClick)
    }

    override fun getItemCount(): Int = films.size

    override fun onBindViewHolder(holder: FilmViewHolder, position: Int) {
        holder.bind(films[position])
    }

    class FilmViewHolder(
        private val binding: ItemFilmBinding,
        private val onFilmClick: (String) -> Unit
    ) : RecyclerView.ViewHolder(binding.root) {

        fun bind(film: SearchItem) {
            Picasso.get().load(film.poster).into(binding.ivPoster)
            binding.tvTitle.text = film.title
            binding.tvYear.text = film.year
            binding.root.setOnClickListener {
                onFilmClick(film.imdbID)
            }
        }

    }

}