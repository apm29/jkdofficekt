package com.shirly.apm29.jkdofficekt.di.component

import com.shirly.apm29.jkdofficekt.ui.SplashActivity
import com.shirly.apm29.jkdofficekt.di.annotations.ApmScope
import dagger.Component

@Component(dependencies = [BaseComponent::class])
@ApmScope
interface SplashComponent {
    fun inject(splashAct: SplashActivity)
}