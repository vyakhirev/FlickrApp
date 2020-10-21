package com.example.flickrapp.repository

import com.example.flickrapp.data.ResponsePhotoItemHolder
import io.reactivex.Flowable
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface FlickrApiService {

    @GET("/services/rest/?method=flickr.photos.getRecent")
    fun getRecent(
            @Query("page") page: Int,
            @Query("per_page") perPage: Int,
            @Query("nojsoncallback") noJsonCallback: String = "nojsoncallback",
            @Query("format") format: String = "json"
    ): Flowable<Response<ResponsePhotoItemHolder>>

    @GET("/services/rest/?method=flickr.photos.search")
    fun getPhotoSearch(
            @Query("text") query: String,
            @Query("page") page: Int,
            @Query("per_page") perPage: Int,
            @Query("nojsoncallback") noJsonCallback: String = "nojsoncallback",
            @Query("format") format: String = "json"
    ): Flowable<Response<ResponsePhotoItemHolder>>
}