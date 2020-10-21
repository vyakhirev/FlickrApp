package com.example.flickrapp.repository

import com.example.flickrapp.data.PhotoItem
import io.reactivex.Completable
import io.reactivex.Flowable
import javax.inject.Inject

class RepositoryImpl @Inject
constructor(private val flickrApiClient: FlickrApiService) : Repository {

    override fun getSearchResults(query: String, page: Int, per_Page: Int): Flowable<List<PhotoItem>> {
      return  flickrApiClient
                .getPhotoSearch(query, page, per_Page)
                .map {
                    it.body()?.photos?.photo
                }
    }

    override fun getCachedPhotoItems(): Flowable<List<PhotoItem>> {
        TODO("Not yet implemented")
    }

    override fun getPageNumber(): Int {
        TODO("Not yet implemented")
    }

    override fun getMaxPageNumber(): Int {
        TODO("Not yet implemented")
    }

    override fun switchFavorite(photoItem: PhotoItem): Completable {
        TODO("Not yet implemented")
    }

    override fun getFavorites(): Flowable<List<PhotoItem>> {
        TODO("Not yet implemented")
    }
}