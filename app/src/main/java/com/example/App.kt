package com.example

import android.app.Application
import com.example.data.RepositoryImpl

class App : Application() {

    override fun onCreate() {
        super.onCreate()
        RepositoryImpl.initRepository(applicationContext)
    }
}