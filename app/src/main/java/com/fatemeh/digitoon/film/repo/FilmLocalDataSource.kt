package com.fatemeh.digitoon.film.repo

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.fatemeh.digitoon.model.Film
import com.fatemeh.digitoon.model.SearchItem
import io.reactivex.Completable
import io.reactivex.Single

@Dao
interface FilmLocalDataSource {

    @Query("SELECT * FROM film")
     fun getFilms(): Single<List<SearchItem>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
     fun insertFilms(films: List<SearchItem>): Completable

}