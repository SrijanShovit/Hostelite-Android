package com.example.hostelite.presentation.landing_pages

import android.annotation.SuppressLint
import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.ClickableText
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBackIos
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.outlined.Email
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.hostelite.presentation.Authentication.AuthenticationViewModel
import com.example.hostelite.util.Response
import kotlinx.coroutines.launch

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun CreateAccountStudent(navController: NavController, viewModel: AuthenticationViewModel) {
    val formValues = listOf<MutableState<String>>(
        remember { mutableStateOf("")},
        remember { mutableStateOf("")},
        remember { mutableStateOf("")},
        remember { mutableStateOf("")},
        remember { mutableStateOf("")},
        remember { mutableStateOf("")},
        remember { mutableStateOf("")},
    )

    val coroutineScope = rememberCoroutineScope()
    val scaffoldState = rememberScaffoldState()
    val context = LocalContext.current

    Scaffold(
        modifier = Modifier.fillMaxSize(),
        scaffoldState = scaffoldState
    ) {
        Box(
            modifier = Modifier.fillMaxSize()
        ){
            IconButton(
                onClick = { navController.popBackStack() },
                modifier = Modifier.padding(10.dp)
            ) {
                Icon(imageVector = Icons.Filled.ArrowBackIos, contentDescription = "Go back")
            }

            Row(
                modifier = Modifier.align(Alignment.BottomCenter)
            ){
                Text(
                    text = "Already have an account?",
                    style = TextStyle(
                        fontSize = 15.sp,
                        fontWeight = FontWeight(500)
                    )
                )
                ClickableText(
                    text = AnnotatedString(
                        text = " Sign In",
                        spanStyle = SpanStyle(
                            color = Color(0xFFF76306),
                            fontSize = 15.sp,
                            fontWeight = FontWeight(500)
                        )
                    ),
                    onClick = {navController.popBackStack()})
            }

            Column(
                modifier = Modifier
                    .align(Alignment.TopCenter)
                    .padding(top = 20.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ){
                Text(
                    text = "Create Account",
                    style = TextStyle(
                        fontSize = 25.sp,
                        color = Color(0xFF787878),
                        fontWeight = FontWeight.W700
                    )
                )
                Text(
                    text = "Get your home here!",
                    style = TextStyle(
                        fontSize = 12.sp,
                        color = Color(0xFF6A6A6A),
                        fontWeight = FontWeight.W400
                    )
                )
                Spacer(modifier = Modifier.height(50.dp))
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 20.dp)
                ){
                    FormInputBox(key = formValues[0], label = "Username")
                    Spacer(modifier = Modifier.height(5.dp))
                    FormInputBox(key = formValues[1], label = "Roll Number")
                    Spacer(modifier = Modifier.height(5.dp))
                    FormInputBox(key = formValues[2], label = "Email", email = true)
                    Spacer(modifier = Modifier.height(5.dp))
                    FormInputBox(key = formValues[3], label = "Room No.")
                    Spacer(modifier = Modifier.height(5.dp))
                    FormInputBox(key = formValues[4], label = "Mobile Number")
                    Spacer(modifier = Modifier.height(5.dp))
                    FormPasswordBox(key = formValues[5], label = "Create Password")
                    Spacer(modifier = Modifier.height(5.dp))
                    FormPasswordBox(key = formValues[6], label = "Confirm Password")
                    Spacer(modifier = Modifier.height(5.dp))
                }
                Spacer(modifier = Modifier.height(10.dp))
                TextButton(
                    onClick = {
                        if(
                            formValues[0].value.isEmpty() ||
                            formValues[1].value.isEmpty() ||
                            formValues[2].value.isEmpty() ||
                            formValues[3].value.isEmpty() ||
                            formValues[4].value.isEmpty() ||
                            formValues[5].value.isEmpty() ||
                            formValues[6].value.isEmpty()
                        ){
                            coroutineScope.launch {
                                scaffoldState.snackbarHostState.showSnackbar(
                                    message = "Enter all the fields",
                                    duration = SnackbarDuration.Short
                                )
                                return@launch
                            }
                        }
                        if(!formValues[2].value.contains('@')){
                            coroutineScope.launch {
                                scaffoldState.snackbarHostState.showSnackbar(
                                    message = "Enter a valid email address",
                                    duration = SnackbarDuration.Short
                                )
                            }
                            return@TextButton
                        }
                        if(formValues[5].value.length < 6 || formValues[6].value.length < 6 || formValues[5].value != formValues[6].value){
                            coroutineScope.launch {
                                scaffoldState.snackbarHostState.showSnackbar(
                                    message = "Enter proper password (6 characters long)",
                                    duration = SnackbarDuration.Short
                                )
                            }
                            return@TextButton
                        }
                        viewModel.studentSignUp(
                            userName = formValues[0].value,
                            rollNo = formValues[1].value,
                            email = formValues[2].value,
                            roomNo = formValues[3].value,
                            mobNo = formValues[4].value,
                            password = formValues[5].value
                        )
                        val response = viewModel.studentSignUpState.value
                        if(response is Response.Success){
                            if (response.data) {
                                navController.navigate(route = "homestudent"){
                                    popUpTo(route = "createStudentAccount"){
                                        inclusive = true
                                    }
                                }
                            }
                            else{
                                Toast.makeText(context, "Sign Up Failed", Toast.LENGTH_SHORT).show()
                            }
                        }
                        else if(response is Response.Error){
                                Toast.makeText(context, response.message, Toast.LENGTH_SHORT).show()
                        }
                    },
                    shape = RoundedCornerShape(corner = CornerSize(15.dp)),
                    modifier = Modifier
                        .clip(RoundedCornerShape(corner = CornerSize(15.dp)))
                        .fillMaxWidth(0.75f)
                        .background(color = Color(0xFF9C32A6))
                ) {
                    Text(
                        text = "Register",
                        style = TextStyle(
                            color = Color.White,
                            fontSize = 18.sp,
                            fontWeight = FontWeight.W400
                        )
                    )
                }
            }
    }
    }

}

@Composable
fun FormPasswordBox(key: MutableState<String>, label: String){
    OutlinedTextField(
        value = key.value,
        onValueChange = {key.value = it},
        label = {Text(text = label)},
        modifier = Modifier.fillMaxWidth(),
        shape = RoundedCornerShape(corner = CornerSize(15.dp)),
        visualTransformation = PasswordVisualTransformation(),
        trailingIcon = {Icon(imageVector = Icons.Filled.Lock, contentDescription = "password")},
        singleLine = true
    )
}
@Composable
fun FormInputBox(key: MutableState<String>, label: String, email: Boolean = false) {
    if (!email) {
        OutlinedTextField(
            value = key.value,
            onValueChange = { key.value = it },
            label = { Text(text = label) },
            modifier = Modifier.fillMaxWidth(),
            shape = RoundedCornerShape(corner = CornerSize(15.dp)),
            singleLine = true
        )
    } else {
        OutlinedTextField(
            value = key.value,
            onValueChange = { key.value = it },
            label = { Text(text = label) },
            modifier = Modifier.fillMaxWidth(),
            shape = RoundedCornerShape(corner = CornerSize(15.dp)),
            trailingIcon = {
                Icon(
                    imageVector = Icons.Outlined.Email,
                    contentDescription = "email"
                )
            },
            singleLine = true
        )
    }
}

