package com.fatemeh.digitoon.detail.repo

import com.fatemeh.digitoon.model.Detail
import io.reactivex.Completable
import io.reactivex.Single

interface DetailRepository {

    fun getDetail(id:String): Single<Detail>

    fun insertDetail(detail: Detail): Completable

}