package com.example.candidatetestapp.viewmodel

import com.example.candidatetestapp.api.ServiceApi
import com.example.candidatetestapp.models.User

class DataRepository(private val api: ServiceApi) {
    fun getData() : User{
        return api.getData()
    }
}