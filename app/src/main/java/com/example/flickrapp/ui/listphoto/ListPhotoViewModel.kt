package com.example.flickrapp.ui.listphoto

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.flickrapp.data.PhotoItem
import com.example.flickrapp.repository.FlickrApiService
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class ListPhotosViewModel @Inject
constructor(
        private val flickrApiService: FlickrApiService
) : ViewModel() {
    var disposable = CompositeDisposable()
    var page = 1
    var perPage = 30

    private val _photos = MutableLiveData<MutableList<PhotoItem>>()
    val photos: LiveData<MutableList<PhotoItem>> = _photos

//    fun switchFavorite(photoItem: PhotoItem) {
//        disposable.add(
//                switchFavoritesUseCase.execute(photoItem)
//                        .subscribeOn(Schedulers.io())
//                        .observeOn(AndroidSchedulers.mainThread())
//                        .subscribe({}, { })
//        )
//    }

    fun getPhoto(query: String) {
        disposable.add(
                flickrApiService.getPhotoSearch(query, page, perPage)
                        .subscribeOn(Schedulers.io())
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribe(
                                {
                                    _photos.value = it.body()?.photos?.photo
                                }, {
                        }
                        )
        )
    }

    override fun onCleared() {
        disposable.clear()
    }
}