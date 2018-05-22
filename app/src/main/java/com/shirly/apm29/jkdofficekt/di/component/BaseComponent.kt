package com.shirly.apm29.jkdofficekt.di.component

import android.os.Handler
import com.shirly.apm29.jkdofficekt.base.ApmApp
import com.shirly.apm29.jkdofficekt.di.module.BaseModule
import dagger.Component
import retrofit2.Retrofit
import javax.inject.Singleton

@Component(modules = [BaseModule::class])
@Singleton
interface BaseComponent{
    fun inject(app: ApmApp)
    fun retrofit(): Retrofit
    fun handler():Handler
}