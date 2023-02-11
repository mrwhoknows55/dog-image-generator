package com.mrwhoknows.dogimagegenerator

import android.app.Application
import dagger.hilt.android.HiltAndroidApp
import timber.log.Timber

@HiltAndroidApp
class DogApplication: Application(){
    override fun onCreate() {
        super.onCreate()
        if (BuildConfig.DEBUG){
            Timber.plant(Timber.DebugTree())
            Timber.i("onCreate: Timber debugTree planted")
        }
    }
}