package com.example.hostelite.di

import com.example.hostelite.data.AuthenticationRepositoryImpl
import com.example.hostelite.domain.use_cases.*
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.storage.FirebaseStorage
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object HosteliteModule {

    @Singleton
    @Provides
    fun provideFirebaseAuthentication() : FirebaseAuth{
        return FirebaseAuth.getInstance()
    }

    @Singleton
    @Provides
    fun provideFirebaseFirestore() : FirebaseFirestore{
        return FirebaseFirestore.getInstance()
    }

    @Singleton
    @Provides
    fun provideFirebaseStorage() : FirebaseStorage{
        return FirebaseStorage.getInstance()
    }

    @Singleton
    @Provides
    fun provideAuthenticationRepository(auth:FirebaseAuth, firestore: FirebaseFirestore) : AuthenticationRepositoryImpl{
        return AuthenticationRepositoryImpl(auth, firestore)
    }

    @Singleton
    @Provides
    fun provideAuthUseCases(repositoryImpl: AuthenticationRepositoryImpl) = AuthenticationUseCases(
        isUserAuthenticated = IsUserAuthenticated(repositoryImpl),
        firebaseSignIn = FirebaseSignIn(repositoryImpl),
        firebaseSignOut = FirebaseSignOut(repositoryImpl),
        firebaseStudentSignUp = FirebaseStudentSignUp(repositoryImpl),
        firebaseAdminSignUp = FirebaseAdminSignUp(repositoryImpl),
        firebaseAuthState = FirebaseAuthState(repositoryImpl)
    )
}