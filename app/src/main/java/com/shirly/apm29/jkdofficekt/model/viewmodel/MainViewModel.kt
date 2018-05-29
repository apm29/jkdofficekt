package com.shirly.apm29.jkdofficekt.model.viewmodel

import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import com.shirly.apm29.jkdofficekt.model.bean.Category

class MainViewModel : ViewModel() {
    var data : MutableLiveData<Category> = MutableLiveData()
    fun setDataValue(value : Category){
        data.value = value
    }
    fun getDataValue(): Category?{
        return data.value
    }

    var key : MutableLiveData<String> = MutableLiveData()

}