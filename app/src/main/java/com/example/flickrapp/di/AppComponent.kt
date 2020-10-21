package com.example.flickrapp.di

import com.example.flickrapp.App
import dagger.Component
import javax.inject.Singleton

@Component(modules = [RetrofitModule::class])
@Singleton
interface AppComponent {

    companion object {

        private var appComponent: AppComponent? = null

        fun create(): AppComponent {
            return appComponent ?: DaggerAppComponent.create().also { appComponent = it }
        }
    }

//    fun provideRetrofit(): Retrofit

    fun inject(app: App)

}