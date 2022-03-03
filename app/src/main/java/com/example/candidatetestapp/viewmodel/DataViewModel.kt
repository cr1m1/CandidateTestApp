package com.example.candidatetestapp.viewmodel

import androidx.lifecycle.ViewModel
import com.example.candidatetestapp.models.User

class DataViewModel : ViewModel() {
    private val dataRepository = DataRepository(JsonParser())
    fun getData(): User = dataRepository.getData()
}