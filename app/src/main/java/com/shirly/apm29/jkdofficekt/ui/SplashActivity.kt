package com.shirly.apm29.jkdofficekt.ui

import android.arch.lifecycle.ViewModelProvider
import android.arch.lifecycle.ViewModelProviders
import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.support.v7.app.AppCompatActivity
import com.example.dingzhu.zuoplus.model.Api
import com.shirly.apm29.jkdofficekt.model.bean.Category
import com.example.dingzhu.zuoplus.model.bean.CategoryListItem
import com.shirly.apm29.jkdofficekt.model.viewmodel.MainViewModel
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
                        {
                            if (it.isSuccess()) {
                                intoTheDead()
                            } else {
                                toLogin()
                            }

                        }, { toLogin() }
                )
        val modelProvider = ViewModelProviders.of(this, ViewModelProvider.AndroidViewModelFactory.getInstance(application))
        val mainViewModel = modelProvider.get("Main", MainViewModel::class.java)
        mainViewModel.setDataValue(
                Category(
                        categoryList = listOf(
                                CategoryListItem("红色", "哈哈", 3)
                        )
                )
        )
        mainViewModel.key.value = "ASDFGHJKL"
    }

    private fun toLogin() {
        handler.postDelayed({
            startActivity(Intent(this, MainActivity::class.java))
        }, 1000)
    }

    private fun intoTheDead() {
        handler.postDelayed({
            startActivity(Intent(this, MainActivity::class.java))
        }, 1000)
    }
}
