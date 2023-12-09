package com.fatemeh.digitoon.film.repo

import com.fatemeh.digitoon.isInternetReachable
import com.fatemeh.digitoon.model.Film
import com.fatemeh.digitoon.model.SearchItem
import io.reactivex.Completable
import io.reactivex.Single


class FilmRepositoryImpl(
    val remoteDataSource: FilmDataSource,
    val localDataSource: FilmLocalDataSource
) : FilmRepository {

    override fun getFilms(): Single<Film> {

//        return if (isInternetReachable())
        return remoteDataSource.getFilms().doOnSuccess { films -> films.search?.let { insertFilms(it) } }
//        else
//            localDataSource.getFilms()

    }

    override fun insertFilms(films: List<SearchItem>): Completable =
        localDataSource.insertFilms(films)


}