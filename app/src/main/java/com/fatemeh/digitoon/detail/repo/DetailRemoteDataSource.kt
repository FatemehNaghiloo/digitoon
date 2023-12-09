package com.fatemeh.digitoon.detail.repo

import com.fatemeh.digitoon.ApiService
import com.fatemeh.digitoon.model.Detail
import io.reactivex.Completable
import io.reactivex.Single

class DetailRemoteDataSource(private val apiService: ApiService) : DetailDataSource {

    override fun getDetail(id:String): Single<Detail> = apiService.getDetail("3e974fca",id)

    override fun insertDetail(detail: Detail): Completable {
        TODO("Not yet implemented")
    }

}