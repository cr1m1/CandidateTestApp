package com.example.candidatetestapp.models

import android.graphics.Bitmap
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "images_table")
data class Photo(
    @ColumnInfo(name = "photo_bmp") val photoBmp: Bitmap,
) {
    @PrimaryKey(autoGenerate = true)
    var id: Int = 0
}