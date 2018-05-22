package com.shirly.apm29.jkdofficekt.base

import android.app.Application
import com.shirly.apm29.jkdofficekt.di.component.DaggerBaseComponent
import com.shirly.apm29.jkdofficekt.di.module.BaseModule
import javax.inject.Inject

class ApmApp : Application() {

    @Inject
    lateinit var appManager: AppManager

    override fun onCreate() {
        super.onCreate()
        println("onCreate")
        DaggerBaseComponent.builder()
                .baseModule(BaseModule(this))
                .build()
                .inject(this)
        registerActivityLifecycleCallbacks(appManager)
    }
}