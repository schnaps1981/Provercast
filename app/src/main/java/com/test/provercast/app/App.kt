package com.test.provercast.app

import android.app.Application
import com.test.provercast.BuildConfig
import com.test.provercast.app.di.AppComponent
import com.test.provercast.app.di.DaggerAppComponent
import com.test.provercast.app.di.modules.ContextModule
import timber.log.Timber

class App : Application() {

    companion object {
        lateinit var instance: AppComponent
    }

    override fun onCreate() {
        super.onCreate()

        instance = DaggerAppComponent.builder()
            .contextModule(ContextModule(this))
            .build()

        initLogger()
        checkApiData()
    }


    private fun initLogger() {
        if (BuildConfig.DEBUG) {
            Timber.plant(Timber.DebugTree())
        } else {
            Timber.plant(object : Timber.Tree() {
                override fun log(priority: Int, tag: String?, message: String, t: Throwable?) {
                }
            })
        }
    }

    private fun checkApiData() {
        if (Constants.API_CX.isBlank()) throw(Exception("Please provide Constants.CX"))
        if (Constants.API_KEY.isBlank()) throw(Exception("Please provide Constants.API_KEY"))
    }

}