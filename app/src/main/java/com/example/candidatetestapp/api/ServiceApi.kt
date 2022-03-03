package com.example.candidatetestapp.api

import com.example.candidatetestapp.models.User

interface ServiceApi {
    fun getData(): User
}