package com.example.candidatetestapp.models

enum class Education { HIGH_SCHOOL, BACHELOR, MASTER, DOCTORAL }

data class Response(
    val user: User
)

data class User(
    val first_name: String,
    val photo: String,
    val second_name: String,
    val education: Int,
    val age: Int,
    val company: List<Company>
)
