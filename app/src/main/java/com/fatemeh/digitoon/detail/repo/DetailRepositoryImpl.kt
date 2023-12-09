package com.fatemeh.digitoon.detail.repo

import com.fatemeh.digitoon.isInternetReachable
import com.fatemeh.digitoon.model.Detail
import io.reactivex.Completable
import io.reactivex.Single

class DetailRepositoryImpl(
    val remoteDataSource: DetailDataSource,
    val localDataSource: DetailLocalDataSource
) : DetailRepository {

    override fun getDetail(id: String): Single<Detail> {

        return if (isInternetReachable())
            remoteDataSource.getDetail(id).
            doOnSuccess { detail -> insertDetail(detail) }

        else
            localDataSource.getDetail(id)

    }

    override fun insertDetail(detail: Detail): Completable =
        localDataSource.insertDetail(detail)

}