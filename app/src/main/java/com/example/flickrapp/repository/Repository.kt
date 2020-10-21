package com.example.flickrapp.repository

import com.example.flickrapp.data.PhotoItem
import io.reactivex.Completable
import io.reactivex.Flowable

interface Repository {

    fun getSearchResults(
            query: String,
            page: Int,
            per_Page: Int
    ): Flowable<List<PhotoItem>>

//    fun updatePhotoItemList(photoItems: List<PhotoItem>)

//    fun getRecentPhotos(
//        page: Int,
//        per_Page: Int
//    ): Flowable<Response<ResponsePhotoItemHolder>>

    fun getCachedPhotoItems(): Flowable<List<PhotoItem>>

//    fun getPaginationStatus(): Boolean

    fun getPageNumber(): Int

    fun getMaxPageNumber(): Int

    fun switchFavorite(photoItem: PhotoItem): Completable

    fun getFavorites(): Flowable<List<PhotoItem>>
}
