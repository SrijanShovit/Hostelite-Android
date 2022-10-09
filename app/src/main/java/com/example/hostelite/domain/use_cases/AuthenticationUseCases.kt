package com.example.hostelite.domain.use_cases

data class AuthenticationUseCases(
    val isUserAuthenticated: IsUserAuthenticated,
    val firebaseAuthState: FirebaseAuthState,
    val firebaseAdminSignUp: FirebaseAdminSignUp,
    val firebaseStudentSignUp: FirebaseStudentSignUp,
    val firebaseSignIn: FirebaseSignIn,
    val firebaseSignOut: FirebaseSignOut
)