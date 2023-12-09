package com.fatemeh.digitoon


import com.chuckerteam.chucker.api.ChuckerInterceptor
import com.fatemeh.digitoon.model.Detail
import com.fatemeh.digitoon.model.Film
import io.reactivex.Single
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface ApiService {

    @GET("?apikey=3e974fca&s=batman")
    fun getFilms(): Single<Film>

    @GET("/")
    fun getDetail(
        @Query("apikey") apiKey: String,
        @Query("i") imdbId: String
    ): Single<Detail>

}

fun createApiServiceInstance(): ApiService {
    val retrofit = Retrofit.Builder()
        .baseUrl("https://www.omdbapi.com/")
        .addConverterFactory(GsonConverterFactory.create())
        .client(
            OkHttpClient.Builder()
                .addInterceptor(ChuckerInterceptor(App.getMyApplicationContext()))
                .build()
        )
        .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
        .build()
    return retrofit.create(ApiService::class.java)
}