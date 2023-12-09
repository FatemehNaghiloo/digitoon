package com.fatemeh.digitoon.film.repo

import com.fatemeh.digitoon.ApiService
import com.fatemeh.digitoon.model.Film
import com.fatemeh.digitoon.model.SearchItem
import io.reactivex.Completable
import io.reactivex.Single

class FilmRemoteDataSource(val apiService: ApiService) :FilmDataSource {

    override fun getFilms(): Single<Film> = apiService.getFilms()

    override fun insertFilms(films: Film): Completable {
        TODO("Not yet implemented")
    }

}