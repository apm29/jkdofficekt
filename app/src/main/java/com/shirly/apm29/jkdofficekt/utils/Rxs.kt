package com.example.dingzhu.zuoplus.utils

import io.reactivex.ObservableTransformer
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

object Rxs {
    fun <U> threadsRx(): ObservableTransformer<U, U> {
        return ObservableTransformer {
            it.observeOn(AndroidSchedulers.mainThread())
                    .subscribeOn(Schedulers.io())
        }
    }
}