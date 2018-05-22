package com.example.dingzhu.zuoplus.model.viewmodel

import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import com.example.dingzhu.zuoplus.model.bean.CategoryContent

class PagerFragmentViewModel : ViewModel() {
    val data:MutableLiveData<CategoryContent> = MutableLiveData()

    fun get(): CategoryContent? {
        return data.value
    }
    fun set(newValue:CategoryContent){
        data.value = newValue
    }
}