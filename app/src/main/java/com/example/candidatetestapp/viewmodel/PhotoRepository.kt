package com.example.candidatetestapp.viewmodel

import com.example.candidatetestapp.db.PhotoDao
import com.example.candidatetestapp.models.Photo

class PhotoRepository(private val dao: PhotoDao) {
    val photoData = dao.getPhotos()
    fun insertPhoto(photo: Photo) {
        dao.insertPhoto(photo)
    }
}