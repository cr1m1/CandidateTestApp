package com.example.candidatetestapp.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.candidatetestapp.models.Photo

@Database(entities = [Photo::class], version = 1)
abstract class PhotoDatabase : RoomDatabase() {
    abstract fun photoDao(): PhotoDao
}