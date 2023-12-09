package com.fatemeh.digitoon.detail.repo

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.fatemeh.digitoon.model.Detail
import io.reactivex.Completable
import io.reactivex.Single


@Dao
interface DetailLocalDataSource : DetailDataSource {

    @Query("SELECT * FROM detail WHERE imdbId = :id")
    override fun getDetail(id: String): Single<Detail>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    override fun insertDetail(detail: Detail): Completable

}