package com.example.candidatetestapp.models

data class User(
    val first_name: String,
    val photo: String,
    val second_name: String,
    val education: Int,
    val age: Int,
    val company: List<Company>
)
