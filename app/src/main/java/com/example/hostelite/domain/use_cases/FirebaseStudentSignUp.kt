package com.example.hostelite.domain.use_cases

import com.example.hostelite.domain.repository.AuthenticationRepository
import javax.inject.Inject

class FirebaseStudentSignUp @Inject constructor(
    private val repository: AuthenticationRepository
) {
    operator fun invoke(
        email: String,
        userName: String,
        password: String,
        rollNo: String,
        mobNo: String,
        roomNo: String
    ) = repository.firebaseStudentSignUp(
        email = email,
        password = password,
        userName = userName,
        rollNo = rollNo,
        mobNo = mobNo,
        roomNo = roomNo
    )
}