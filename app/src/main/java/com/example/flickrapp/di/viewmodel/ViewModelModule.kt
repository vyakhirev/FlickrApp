package com.example.flickrapp.di.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.flickrapp.ui.listphoto.ListPhotosViewModel
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.multibindings.IntoMap
import javax.inject.Singleton

@Module
interface ViewModelModule {

    companion object {
        @Provides
        @Singleton
        fun viewModelsHolder(): @JvmSuppressWildcards HashMap<Class<out ViewModel>, ViewModel> {
            return HashMap()
        }

    }

    @Binds
    fun bindViewModelFactory(factory: ViewModelFactoryProvider): ViewModelProvider.Factory

    @Binds
    @IntoMap
    @ViewModelKey(ListPhotosViewModel::class)
    fun bindsListPhotosViewModel(listPhotosViewModel: ListPhotosViewModel): ViewModel
}