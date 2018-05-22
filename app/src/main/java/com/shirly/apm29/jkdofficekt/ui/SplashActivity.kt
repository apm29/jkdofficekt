package com.shirly.apm29.jkdofficekt.ui

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.support.v7.app.AppCompatActivity
import android.widget.Toast
import com.example.dingzhu.zuoplus.model.Api
import com.example.dingzhu.zuoplus.utils.Rxs
import com.shirly.apm29.jkdofficekt.R
import com.shirly.apm29.jkdofficekt.di.component.DaggerBaseComponent
import com.shirly.apm29.jkdofficekt.di.component.DaggerSplashComponent
import com.shirly.apm29.jkdofficekt.di.module.BaseModule
import retrofit2.Retrofit
import javax.inject.Inject

class SplashActivity : AppCompatActivity() {

    @Inject
    lateinit var retro: Retrofit
    @Inject
    lateinit var handler: Handler

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)
        DaggerSplashComponent.builder()
                .baseComponent(DaggerBaseComponent.builder().baseModule(BaseModule(this.application)).build())
                .build()
                .inject(this)

        retro.create(Api::class.java)
                .profile()
                .compose(Rxs.threadsRx())
                .subscribe(
                        {intoTheDead()}, { toLogin() }
                )
        val sum = fun Int.(other:Int) = this+other
    }

    private fun toLogin() {
        Toast.makeText(this,"login",Toast.LENGTH_SHORT).show()
    }

    private fun intoTheDead() {
        handler.postDelayed({
            startActivity(Intent(this,MainActivity::class.java))
        }, 1000)
    }
}
