package com.example.flickrapp.di.viewmodel

import com.example.flickrapp.di.RetrofitModule
import com.example.flickrapp.ui.listphoto.ListPhotosFragment
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(
        modules = [ViewModelModule::class, RetrofitModule::class]
)
interface ViewModelComponent : ViewModelsProvider {
    fun inject(listPhotosFragment: ListPhotosFragment)
}