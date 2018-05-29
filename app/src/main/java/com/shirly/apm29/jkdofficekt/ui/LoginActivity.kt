package com.shirly.apm29.jkdofficekt.ui

import android.animation.Animator
import android.animation.AnimatorListenerAdapter
import android.annotation.TargetApi
import android.content.pm.PackageManager
import android.support.design.widget.Snackbar
import android.support.v7.app.AppCompatActivity
import android.app.LoaderManager.LoaderCallbacks
import android.content.CursorLoader
import android.content.Loader
import android.database.Cursor
import android.net.Uri
import android.os.AsyncTask
import android.os.Build
import android.os.Bundle
import android.provider.ContactsContract
import android.text.TextUtils
import android.view.View
import android.view.inputmethod.EditorInfo
import android.widget.ArrayAdapter
import android.widget.TextView

import java.util.ArrayList
import android.Manifest.permission.READ_CONTACTS
import android.content.Intent
import android.text.SpannableStringBuilder
import android.widget.Toast
import com.example.dingzhu.zuoplus.model.Api
import com.example.dingzhu.zuoplus.utils.Rxs
import com.shirly.apm29.jkdofficekt.R
import com.shirly.apm29.jkdofficekt.utils.ToastWrapper
import com.shirly.apm29.jkdofficekt.utils.toast

import kotlinx.android.synthetic.main.activity_login2.*
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

/**
 * A login screen that offers login via email/password.
 */
class LoginActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login2)
        email.text=SpannableStringBuilder.valueOf("admin")
        password.text=SpannableStringBuilder.valueOf("admin")
        password.setOnEditorActionListener(TextView.OnEditorActionListener { _, id, _ ->
            if (id == EditorInfo.IME_ACTION_DONE || id == EditorInfo.IME_NULL) {
                attemptLogin()
                return@OnEditorActionListener true
            }
            false
        })

        email_sign_in_button.setOnClickListener { attemptLogin() }
    }

    private fun attemptLogin() {
        val username = email.text.toString().trim()
        val pwd = password.text.toString().trim()

        // Check for a valid email address.
        if (TextUtils.isEmpty(username)) {
            email.error = getString(R.string.error_field_required)
        } else if (!isEmailValid(pwd)) {
            email.error = getString(R.string.error_invalid_email)
        }

        if (isEmailValid(username) && isPasswordValid(pwd)) {
            val retrofit = Retrofit.Builder()
                    .baseUrl("http://192.168.56.1:8080")
                    .addConverterFactory(GsonConverterFactory.create())
                    .addCallAdapterFactory(RxJava2CallAdapterFactory.create())//新的配置
                    .build()
            retrofit.create(Api::class.java).login(username, pwd)
                    .compose(Rxs.threadsRx())
                    .subscribe(
                            {
                                println(it)
                                toast{
                                    text = it.msg
                                    showSuccess = true
                                }
                                if (it.isSuccess()){
                                    startActivity(Intent(this,SplashActivity::class.java))
                                }
                            },
                            {
                                println(it)
                                password.error = getString(R.string.error_invalid_password)
                            }
                    )
        }
    }


    private fun isEmailValid(email: String): Boolean {
        //TODO: Replace this with your own logic
        return email.length > 4
    }

    private fun isPasswordValid(password: String): Boolean {
        //TODO: Replace this with your own logic
        return password.length > 4
    }


    object ProfileQuery {
        val PROJECTION = arrayOf(
                ContactsContract.CommonDataKinds.Email.ADDRESS,
                ContactsContract.CommonDataKinds.Email.IS_PRIMARY)
        val ADDRESS = 0
        val IS_PRIMARY = 1
    }


}
