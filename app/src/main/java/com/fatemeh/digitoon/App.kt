package com.fatemeh.digitoon

import android.app.Application
import android.content.Context
import android.os.StrictMode
import androidx.room.Room
import com.fatemeh.digitoon.detail.DetailViewModel
import com.fatemeh.digitoon.detail.repo.DetailRemoteDataSource
import com.fatemeh.digitoon.detail.repo.DetailRepository
import com.fatemeh.digitoon.detail.repo.DetailRepositoryImpl
import com.fatemeh.digitoon.film.FilmViewModel
import com.fatemeh.digitoon.film.repo.FilmRemoteDataSource
import com.fatemeh.digitoon.film.repo.FilmRepository
import com.fatemeh.digitoon.film.repo.FilmRepositoryImpl
import org.koin.android.ext.koin.androidContext
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.context.startKoin
import org.koin.dsl.module

class App : Application() {
    override fun onCreate() {
        super.onCreate()
        application = this
        val myModules = module {
            single { createApiServiceInstance() }
            single { Room.databaseBuilder(this@App, AppDatabase::class.java, "db_app").build() }
            factory<FilmRepository> {
                FilmRepositoryImpl(
                    FilmRemoteDataSource(get()),
                    get<AppDatabase>().filmDao()
                )
            }
            viewModel { FilmViewModel(get()) }
            factory<DetailRepository> {
                DetailRepositoryImpl(
                    DetailRemoteDataSource(get()),
                    get<AppDatabase>().detailDao()
                )
            }
            viewModel { (imdbId: String) -> DetailViewModel(imdbId, get()) }
        }

        startKoin {
            androidContext(this@App)
            modules(myModules)
        }
        val policy = StrictMode.ThreadPolicy.Builder().permitAll().build()
        StrictMode.setThreadPolicy(policy)
    }

    companion object {
        lateinit var application: Application

        fun getMyApplicationContext(): Context {
            return application.applicationContext
        }

    }
}