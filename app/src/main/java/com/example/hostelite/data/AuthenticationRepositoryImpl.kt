package com.example.hostelite.data

import com.example.hostelite.domain.model.StudentUser
import com.example.hostelite.domain.repository.AuthenticationRepository
import com.example.hostelite.util.Constants
import com.example.hostelite.util.Response
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.coroutines.channels.awaitClose
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.callbackFlow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.tasks.await
import java.lang.Exception
import javax.inject.Inject

class AuthenticationRepositoryImpl @Inject constructor(
    private val auth : FirebaseAuth,
    private val firestore: FirebaseFirestore,
) : AuthenticationRepository {

    var operationSuccessful = false
    override fun isUserAuthenticated(): Boolean {
        return auth.currentUser != null
    }


    override fun getFirebaseAuthState(): Flow<Boolean>  = callbackFlow{
        val authStateListener = FirebaseAuth.AuthStateListener {
            trySend(auth.currentUser == null)
        }
        auth.addAuthStateListener(authStateListener)
        awaitClose {
            auth.removeAuthStateListener(authStateListener)
        }
        
    }

    override fun firebaseSignIn(email: String, password: String): Flow<Response<Boolean>> = flow{
        operationSuccessful = false
        try {
            emit(Response.Loading)
            auth.signInWithEmailAndPassword(email, password).addOnSuccessListener {
                operationSuccessful = true
            }.await()
            emit(Response.Success(operationSuccessful))
        }catch (e: Exception){
            emit(Response.Error(e.message ?: "An unexpected error"))
        }
    }

    override fun firebaseSignOut(): Flow<Response<Boolean>> = flow{
        try{
            emit(Response.Loading)
            auth.signOut()
            emit(Response.Success(true))
        }catch (e: Exception){
            emit(Response.Error(e.message ?: "An Unexpected Error"))
        }
    }

    override fun firebaseStudentSignUp(
        email: String,
        password: String,
        userName: String,
        rollNo: String,
        roomNo: String,
        mobNo: String
    ): Flow<Response<Boolean>> = flow {
        operationSuccessful = false
        try{
            emit(Response.Loading)
            auth.createUserWithEmailAndPassword(email, password).addOnSuccessListener {
                operationSuccessful = true
            }.await()
            if (operationSuccessful){
                val userId = auth.currentUser?.uid!!
                val obj = StudentUser(
                    userId = userId,
                    userName = userName,
                    email = email,
                    password = password,
                    rollNo = rollNo,
                    roomNo = roomNo,
                    mobNo = mobNo
                )
                firestore.collection(Constants.COLLECTION_NAME_STUDENTS).document(userId).set(obj).addOnSuccessListener {

                }.await()
                emit(Response.Success(operationSuccessful))
            }
            else{
                emit(Response.Success(operationSuccessful))
            }
        }catch (e: Exception){
            emit(Response.Error(e.message ?: "An unexpected error"))
        }
    }

    override fun firebaseAdminSignUp(
        email: String,
        password: String,
        userName: String,
        mobNo: String
    ): Flow<Response<Boolean>> = flow{
        var operationSuccessful = false
        try{
            emit(Response.Loading)
            auth.createUserWithEmailAndPassword(email, password).addOnSuccessListener {
                operationSuccessful = true
            }.await()
            if (operationSuccessful){
                val userId = auth.currentUser?.uid!!
                val obj = StudentUser(
                    userId = userId,
                    userName = userName,
                    email = email,
                    password = password,
                    mobNo = mobNo
                )
                firestore.collection(Constants.COLLECTION_NAME_ADMINS).document(userId).set(obj).addOnSuccessListener {

                }.await()
                emit(Response.Success(operationSuccessful))
            }
            else{
                emit(Response.Success(operationSuccessful))
            }
        }catch (e: Exception){
            emit(Response.Error(e.message ?: "An unexpected error"))
        }
    }

}