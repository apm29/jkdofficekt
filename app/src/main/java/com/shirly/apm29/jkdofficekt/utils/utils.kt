package com.shirly.apm29.jkdofficekt.utils

import android.annotation.SuppressLint
import android.content.Context
import android.support.annotation.DrawableRes
import android.view.LayoutInflater
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import com.shirly.apm29.jkdofficekt.R
import com.shirly.apm29.jkdofficekt.base.ApmApp

class ToastWrapper {

    var text: String? = null

    var res: Int? = null

    var showSuccess: Boolean = false

    var showError: Boolean = false
}

fun toast(init: ToastWrapper.() -> Unit) {
    val wrap = ToastWrapper()

    wrap.init()

    execute(wrap)
}

@SuppressLint("ShowToast")
private fun execute(wrap: ToastWrapper) {

    var toast: Toast? = null

    wrap.text?.let {

        toast = Toast.makeText(getApplicationContext(), it, Toast.LENGTH_LONG)
    }

    wrap.res?.let {

        toast = Toast.makeText(getApplicationContext(), it, Toast.LENGTH_LONG)
    }

    if (wrap.showSuccess) {

        toast = withSuccessIcon(str = wrap.text)
    } else if (wrap.showError) {

        toast = withErrorIcon(str = wrap.text)
    }

    toast?.show()
}


fun withErrorIcon(@DrawableRes iconRes: Int = android.R.drawable.stat_notify_error, str: String?): Toast {
    val inflate = LayoutInflater.from(getApplicationContext()).inflate(R.layout.inflate_toast_custom_layout, null)
    val imageView = inflate.findViewById<ImageView>(R.id.imageView)
    val textView = inflate.findViewById<TextView>(R.id.textView)

    textView.text = str
    imageView.setImageResource(iconRes)
    val toast = Toast(getApplicationContext())
    toast.view = inflate
    return toast
}

fun withSuccessIcon(@DrawableRes iconRes: Int = android.R.drawable.star_big_on, str: String?): Toast {
    val inflate = LayoutInflater.from(getApplicationContext()).inflate(R.layout.inflate_toast_custom_layout, null)
    val imageView = inflate.findViewById<ImageView>(R.id.imageView)
    val textView = inflate.findViewById<TextView>(R.id.textView)

    textView.text = str
    imageView.setImageResource(iconRes)
    val toast = Toast(getApplicationContext())
    toast.view = inflate
    return toast
}

fun getApplicationContext(): Context? {
    return ApmApp.getApplication()
}
