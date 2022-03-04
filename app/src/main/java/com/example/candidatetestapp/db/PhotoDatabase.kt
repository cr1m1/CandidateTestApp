package com.example.candidatetestapp.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.candidatetestapp.models.Photo
import com.example.candidatetestapp.utils.PhotoConverters

@Database(entities = [Photo::class], version = 1)
@TypeConverters(PhotoConverters::class)
abstract class PhotoDatabase : RoomDatabase() {
    abstract fun photoDao(): PhotoDao

    companion object {
        private var dbInstance: PhotoDatabase? = null

        fun getDatabase(context: Context): PhotoDatabase =
            dbInstance ?: synchronized(this) {
                dbInstance ?: buildDatabase(context).also { dbInstance = it }
            }

        private fun buildDatabase(context: Context) =
            Room.databaseBuilder(
                context.applicationContext,
                PhotoDatabase::class.java, "photo_database"
            ).build()
    }
}