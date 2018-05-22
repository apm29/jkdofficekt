package com.shirly.apm29.jkdofficekt.model.bean

import android.databinding.BaseObservable
import android.databinding.Bindable
import com.google.gson.annotations.SerializedName

 class InitData(
    @Bindable
    @SerializedName("parent_real_name")
    var parentRealName: String?,
  //xxxxx
    @Bindable
    @SerializedName("parent_mobile")
    var parentMobile: String?,
  //139xxxxxxxx
    @Bindable
    @SerializedName("mobile")
    var mobile: String?,
  //147xxxxxxxx
    @Bindable
    @SerializedName("type")
    var type: Int?,
  //0
    @Bindable
    @SerializedName("is_master")
    var isMaster: Int?,
  //1
    @Bindable
    @SerializedName("is_real")
    var isReal: Int?
  //1
):BaseObservable()