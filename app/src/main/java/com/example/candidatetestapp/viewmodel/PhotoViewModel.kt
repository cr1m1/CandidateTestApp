package com.example.candidatetestapp.viewmodel

import android.app.Application
import androidx.lifecycle.ViewModel
import com.example.candidatetestapp.db.PhotoDatabase
import com.example.candidatetestapp.models.Photo

class PhotoViewModel(application: Application) : ViewModel() {
    private val dao = PhotoDatabase.getDatabase(application).photoDao()
    private val repository = PhotoRepository(dao)

    val photoData = repository.photoData

    fun insertPhoto(photo: Photo) {
        repository.insertPhoto(photo)
    }
}