package com.shirly.apm29.jkdofficekt.base

import android.app.Activity
import android.app.Application
import android.os.Bundle

class AppManager:Application.ActivityLifecycleCallbacks {
    override fun onActivityPaused(activity: Activity?) {
        println("activity = [$activity]")
    }

    override fun onActivityResumed(activity: Activity?) {
    }

    override fun onActivityStarted(activity: Activity?) {
    }

    override fun onActivityDestroyed(activity: Activity?) {
    }

    override fun onActivitySaveInstanceState(activity: Activity?, outState: Bundle?) {
    }

    override fun onActivityStopped(activity: Activity?) {
    }

    override fun onActivityCreated(activity: Activity?, savedInstanceState: Bundle?) {
    }
}