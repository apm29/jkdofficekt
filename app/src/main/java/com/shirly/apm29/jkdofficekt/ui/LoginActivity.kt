package com.shirly.apm29.jkdofficekt.ui

import android.app.Application
import android.content.Intent
import android.os.Bundle
import android.provider.ContactsContract
import android.support.v7.app.AppCompatActivity
import android.text.SpannableStringBuilder
import android.text.TextUtils
import android.view.inputmethod.EditorInfo
import android.widget.TextView
import com.example.dingzhu.zuoplus.model.Api
import com.example.dingzhu.zuoplus.utils.Rxs
import com.shirly.apm29.jkdofficekt.R
import com.shirly.apm29.jkdofficekt.di.component.DaggerBaseComponent
import com.shirly.apm29.jkdofficekt.di.module.BaseModule
import com.shirly.apm29.jkdofficekt.utils.toast
import kotlinx.android.synthetic.main.activity_login2.*
import retrofit2.Retrofit
import javax.inject.Inject

/**
 * A login screen that offers login via email/password.
 */
class LoginActivity : AppCompatActivity() {

    @Inject
    lateinit var retrofit:Retrofit

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login2)
        email.text=SpannableStringBuilder.valueOf("username")
        password.text=SpannableStringBuilder.valueOf("123123")
        password.setOnEditorActionListener(TextView.OnEditorActionListener { _, id, _ ->
            if (id == EditorInfo.IME_ACTION_DONE || id == EditorInfo.IME_NULL) {
                attemptLogin()
                return@OnEditorActionListener true
            }
            false
        })

        email_sign_in_button.setOnClickListener { attemptLogin() }

        retrofit = DaggerBaseComponent.builder()
                .baseModule(BaseModule(application))
                .build()
                .retrofit()
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
            retrofit.create(Api::class.java)
                    .login(username, pwd)
                    .compose(Rxs.threadsRx())
                    .subscribe(
                            {
                                println(it)
                                toast{
                                    text = it.msg
                                    showSuccess = true
                                }
                                if (it.isSuccess()){
                                    application.getSharedPreferences("ZPLUS", Application.MODE_PRIVATE)
                                            .edit()
                                            .putString("access_token",it.data?.accessToken)
                                            .apply()
                                    startActivity(Intent(this,MainActivity::class.java))
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
