package com.example.candidatetestapp.db

import androidx.room.Query
import com.example.candidatetestapp.models.Photo

interface PhotoDao {
    @Query("SELECT * FROM images_table ORDER BY id ASC")
    fun getPhotos(): List<Photo>
}