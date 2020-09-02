package com.bearweather.android

import android.annotation.SuppressLint
import android.app.Application
import android.content.Context
class BearWeatherApplication: Application() {
    companion object{
        const val TOKEN = "eSi40BTxDGu03bdG"
        @SuppressLint("StaticFieldLeak")
        lateinit var context: Context
    }
    override fun onCreate() {
        super.onCreate()
        context = applicationContext
    }
}