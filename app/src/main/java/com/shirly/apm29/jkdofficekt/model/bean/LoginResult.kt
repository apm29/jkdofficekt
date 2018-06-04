package com.shirly.apm29.jkdofficekt.model.bean

import android.databinding.BaseObservable
import android.databinding.Bindable
import com.google.gson.annotations.SerializedName


data class LoginResult(
    @SerializedName("access_token")
    var accessToken: String?
)