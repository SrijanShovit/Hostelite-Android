package com.example.hostelite.domain.use_cases

import com.example.hostelite.domain.repository.AuthenticationRepository
import javax.inject.Inject

class FirebaseSignIn@Inject constructor(
    private val repository: AuthenticationRepository
) {
    operator fun invoke(email: String, password: String) = repository.firebaseSignIn(email, password)
}