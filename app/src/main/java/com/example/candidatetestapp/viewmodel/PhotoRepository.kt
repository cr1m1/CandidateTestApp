package com.example.candidatetestapp.viewmodel

import androidx.lifecycle.LiveData
import com.example.candidatetestapp.db.PhotoDao
import com.example.candidatetestapp.models.Photo

class PhotoRepository(private val dao: PhotoDao) {
    val photoData: LiveData<List<Photo>> = dao.getPhotos()
    suspend fun insertPhoto(photo: Photo) {
        dao.insertPhoto(photo)
    }
}