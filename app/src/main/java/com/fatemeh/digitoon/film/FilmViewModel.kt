package com.fatemeh.digitoon.film

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.fatemeh.digitoon.film.repo.FilmRepository
import com.fatemeh.digitoon.model.Film
import io.reactivex.SingleObserver
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers

class FilmViewModel(filmRepository: FilmRepository) : ViewModel() {

    val compositeDisposable = CompositeDisposable()
    val progressBarLiveData = MutableLiveData<Boolean>()
    val filmsLiveData = MutableLiveData<Film>()

    init {
        progressBarLiveData.value = true
        filmRepository.getFilms()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .doFinally { progressBarLiveData.value = false }
            .subscribe(object : SingleObserver<Film> {

                override fun onSubscribe(d: Disposable) {
                    compositeDisposable.add(d)
                }

                override fun onSuccess(t:Film) {
                    filmsLiveData.value = t
                }

                override fun onError(e: Throwable) {
                    Log.i("FilmViewModel", e.toString())
                }

            })

    }

    override fun onCleared() {
        compositeDisposable.clear()
        super.onCleared()
    }

}