package com.fatemeh.digitoon.film.repo

import com.fatemeh.digitoon.model.Film
import com.fatemeh.digitoon.model.SearchItem
import io.reactivex.Completable
import io.reactivex.Single

interface FilmRepository {

    fun getFilms(): Single<Film>

    fun insertFilms(films: List<SearchItem>): Completable

}