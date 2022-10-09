package com.example.hostelite.presentation.Authentication

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.hostelite.domain.use_cases.AuthenticationUseCases
import com.example.hostelite.util.Response
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AuthenticationViewModel @Inject constructor(
    private val authUseCase : AuthenticationUseCases
) : ViewModel() {

    val isUserAuthenticated get() = authUseCase.isUserAuthenticated()

    private val _signInState = mutableStateOf<Response<Boolean>>(Response.Success(false))
    val signInState : State<Response<Boolean>> = _signInState

    private val _adminSignUpState = mutableStateOf<Response<Boolean>>(Response.Success(false))
    val adminSignUpState: State<Response<Boolean>> = _adminSignUpState

    private val _studentSignUpState = mutableStateOf<Response<Boolean>>(Response.Success(false))
    val studentSignUpState : State<Response<Boolean>> = _studentSignUpState

    private val _signOutState = mutableStateOf<Response<Boolean>>(Response.Success(false))
    val signOutState : State<Response<Boolean>> = _signOutState
    
    private val _firebaseAuthState = mutableStateOf<Boolean>(false)
    val firebaseAuthState : State<Boolean> = _firebaseAuthState

    fun signIn(email: String, password: String){
        viewModelScope.launch {
            authUseCase.firebaseSignIn(email, password).collect {
                _signInState.value = it
            }
        }
    }

    fun adminSignUp(userName: String, email: String, password: String, mobNo: String){
        viewModelScope.launch {
            authUseCase.firebaseAdminSignUp(userName, email, password, mobNo).collect {
                _adminSignUpState.value = it
            }
        }
    }

    fun studentSignUp(
        userName: String,
        email: String,
        password: String,
        mobNo: String,
        rollNo: String,
        roomNo: String
    ){
        viewModelScope.launch {
            authUseCase.firebaseStudentSignUp(
                email, userName, password, rollNo, mobNo, roomNo
            ).collect {
                _adminSignUpState.value = it
            }
        }
    }

    fun signOut(){
        viewModelScope.launch {
            authUseCase.firebaseSignOut().collect {
                _signOutState.value = it
                if (it == Response.Success(true)){
                    _signInState.value = Response.Success(false)
                }
            }
        }
    }

    fun getFirebaseAuthState(){
        viewModelScope.launch {
            authUseCase.firebaseAuthState().collect {
                _firebaseAuthState.value = it
            }
        }
    }
}