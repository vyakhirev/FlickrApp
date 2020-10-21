package com.example.flickrapp.data

data class PhotoResult(
        val page: Int,
        val pages: Int,
        val perpage: Int,
        val total: Int,
        val photo: MutableList<PhotoItem>
)