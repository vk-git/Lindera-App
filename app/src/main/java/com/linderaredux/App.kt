package com.linderaredux

import android.app.Activity
import android.app.Application
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.linderaredux.dagger.DaggerAppComponent
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasActivityInjector
import javax.inject.Inject
import io.sentry.android.AndroidSentryClientFactory
import io.sentry.Sentry

class App : Application(), HasActivityInjector, Application.ActivityLifecycleCallbacks {

    @set:Inject
    lateinit var activityDispatchingAndroidInjector: DispatchingAndroidInjector<Activity>

    lateinit var currentActivity: AppCompatActivity

    init {
        instance = this
    }

    companion object {
        lateinit var instance: App
    }

    override fun onCreate() {
        super.onCreate()
        instance = this

        DaggerAppComponent.builder()
            .application(this)
            .build()
            .inject(this)

        //Sentry Init
        val sentryDsn = "https://0ac2d2f30caa4e26b89ef32b092bc4af@sentry.lindera.de/4"
        Sentry.init(sentryDsn, AndroidSentryClientFactory(this))

        registerActivityLifecycleCallbacks(this)
    }

    override fun activityInjector(): DispatchingAndroidInjector<Activity> {
        return activityDispatchingAndroidInjector
    }

    override fun onActivityPaused(activity: Activity?) {

    }

    override fun onActivityResumed(activity: Activity?) {
        currentActivity = activity as AppCompatActivity
    }

    override fun onActivityStarted(activity: Activity?) {
        currentActivity = activity as AppCompatActivity
    }

    override fun onActivityDestroyed(activity: Activity?) {

    }

    override fun onActivitySaveInstanceState(activity: Activity?, outState: Bundle?) {

    }

    override fun onActivityStopped(activity: Activity?) {

    }

    override fun onActivityCreated(activity: Activity?, savedInstanceState: Bundle?) {
        currentActivity = activity as AppCompatActivity
    }
}