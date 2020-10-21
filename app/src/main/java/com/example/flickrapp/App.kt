package com.example.flickrapp

import android.app.Application
import com.example.flickrapp.di.AppComponent

class App: Application() {

    companion object {
        private var appComponent: AppComponent? = null
    }

    override fun onCreate() {
        super.onCreate()
        getAppComponent().inject(this)
    }

    fun getAppComponent(): AppComponent {
        return appComponent ?: AppComponent.create().also {
            appComponent = it
        }
    }
}