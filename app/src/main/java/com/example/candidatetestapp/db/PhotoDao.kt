package com.example.candidatetestapp.db

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.candidatetestapp.models.Photo

@Dao
interface PhotoDao {
    @Query("SELECT * FROM images_table ORDER BY id ASC")
    fun getPhotos(): LiveData<List<Photo>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertPhoto(photo: Photo)
}