package com.example.hostelite.domain.repository

import com.example.hostelite.util.Response
import kotlinx.coroutines.flow.Flow

interface AuthenticationRepository {
    fun isUserAuthenticated() : Boolean
    fun getFirebaseAuthState() : Flow<Boolean>
    fun firebaseSignIn(email: String, password: String) : Flow<Response<Boolean>>
    fun firebaseSignOut() : Flow<Response<Boolean>>
    fun firebaseStudentSignUp(
        email: String,
        password: String,
        userName: String,
        rollNo: String,
        roomNo: String,
        mobNo: String
    ) : Flow<Response<Boolean>>
    fun firebaseAdminSignUp(
        email: String,
        password: String,
        userName: String,
        mobNo: String
    ) : Flow<Response<Boolean>>

}