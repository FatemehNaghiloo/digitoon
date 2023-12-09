package com.fatemeh.digitoon.detail

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.fatemeh.digitoon.detail.repo.DetailRepository
import com.fatemeh.digitoon.model.Detail
import io.reactivex.SingleObserver
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers

class DetailViewModel(imdbId: String, detailRepository: DetailRepository) : ViewModel() {

    val detailLiveData = MutableLiveData<Detail>()
    val compositeDisposable = CompositeDisposable()
    val progressBarLiveData= MutableLiveData<Boolean>()

    init {
        progressBarLiveData.value = true
        detailRepository.getDetail(imdbId)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .doFinally { progressBarLiveData.value = false }
            .subscribe(object : SingleObserver<Detail> {

                override fun onSubscribe(d: Disposable) {
                    compositeDisposable.add(d)
                }

                override fun onSuccess(t: Detail) {
                    detailLiveData.value = t
                }

                override fun onError(e: Throwable) {
                    Log.i("DetailViewModel", e.toString())
                }

            })

    }

    override fun onCleared() {
        compositeDisposable.clear()
        super.onCleared()
    }

}