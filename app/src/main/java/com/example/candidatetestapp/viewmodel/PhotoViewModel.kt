package com.example.candidatetestapp.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.example.candidatetestapp.db.PhotoDatabase
import com.example.candidatetestapp.models.Photo
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class PhotoViewModel(application: Application) : AndroidViewModel(application) {
    private val dao = PhotoDatabase.getDatabase(application).photoDao()
    private val repository = PhotoRepository(dao)

    val photoData: LiveData<List<Photo>> = repository.photoData

    fun insertPhoto(photo: Photo) {
        viewModelScope.launch(Dispatchers.IO) {
            repository.insertPhoto(photo)
        }
    }
}