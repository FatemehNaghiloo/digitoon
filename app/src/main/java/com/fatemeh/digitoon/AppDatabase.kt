package com.fatemeh.digitoon

import androidx.room.Database
import androidx.room.RoomDatabase
import com.fatemeh.digitoon.detail.repo.DetailLocalDataSource
import com.fatemeh.digitoon.film.repo.FilmLocalDataSource
import com.fatemeh.digitoon.model.Detail
import com.fatemeh.digitoon.model.Film
import com.fatemeh.digitoon.model.SearchItem

@Database(entities = [SearchItem::class, Detail::class], version = 1, exportSchema = false)
abstract class AppDatabase : RoomDatabase() {

    abstract fun filmDao(): FilmLocalDataSource

    abstract fun detailDao(): DetailLocalDataSource

}