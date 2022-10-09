package com.example.hostelite.domain.model

data class AdminUser(
    val userName: String,
    val userId: String,
    val email: String,
    val password: String,
    val mobNo: String,
    val dpUrl: String
)
