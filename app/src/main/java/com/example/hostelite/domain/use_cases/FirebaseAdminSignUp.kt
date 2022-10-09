package com.example.hostelite.domain.use_cases

import com.example.hostelite.domain.repository.AuthenticationRepository
import javax.inject.Inject

class FirebaseAdminSignUp @Inject constructor(
    private val repository: AuthenticationRepository
) {
    operator fun invoke(
        userName: String,
        email: String,
        password: String,
        mobNo: String,
    ) = repository.firebaseAdminSignUp(
        email, password, userName, mobNo
    )
}