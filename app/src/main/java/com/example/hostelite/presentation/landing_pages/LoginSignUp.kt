package com.example.hostelite.presentation.landing_pages

import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.ClickableText
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.outlined.Email
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.unit.dp
import com.example.hostelite.R
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.hostelite.presentation.Authentication.AuthenticationViewModel
import com.example.hostelite.util.Response
import kotlinx.coroutines.launch

@Composable
fun Login(
    navController: NavController,
    viewModel: AuthenticationViewModel
) {
    var emailValue = remember {mutableStateOf("")}
    var passValue = remember {mutableStateOf("")}
    var isStudent = remember {mutableStateOf(true)}

    val scaffoldState = rememberScaffoldState()
    val coroutineScope = rememberCoroutineScope()

    Box(
        modifier = Modifier
            .padding(horizontal = 40.dp, vertical = 30.dp)
            .fillMaxSize()){
        Scaffold(
            modifier = Modifier.fillMaxSize(),
            scaffoldState = scaffoldState
        ) {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier
                    .align(Alignment.TopCenter)
                    .fillMaxSize()
            ){
                Image(
                    painter = painterResource(id = R.drawable.hostellite),
                    contentDescription = "Hostellite Logo",
                    modifier = Modifier
                        .fillMaxWidth()
                )
                Spacer(modifier = Modifier.height(80.dp))
                Text(
                    text = "SIGN IN",
                    style = TextStyle(
                        fontSize = 30.sp,
                        fontWeight = FontWeight(400)
                    )
                )
                Text(
                    text = "Get your home here!",
                    style = TextStyle(
                        fontSize = 12.sp,
                        fontWeight = FontWeight(400)
                    )
                )
                Spacer(modifier = Modifier.height(40.dp))
                OutlinedTextField(
                    value = emailValue.value,
                    onValueChange = {emailValue.value = it},
                    label = {Text("Email Address")},
                    placeholder = {Text("xyz@gmail.com")},
                    trailingIcon = { Icon(imageVector = Icons.Outlined.Email, contentDescription = "email-id")},
                    modifier = Modifier.fillMaxWidth(),
                    singleLine = true
                )
                Spacer(modifier = Modifier.height(20.dp))
                OutlinedTextField(
                    value = passValue.value,
                    onValueChange = {passValue.value = it},
                    label = {Text("Password")},
                    placeholder = {Text("***************")},
                    trailingIcon = { Icon(imageVector = Icons.Filled.Lock, contentDescription = "password")},
                    visualTransformation = PasswordVisualTransformation(),
                    modifier = Modifier.fillMaxWidth(),
                    singleLine = true
                )

                Spacer(modifier = Modifier.height(10.dp))
                Row(
                    horizontalArrangement = Arrangement.SpaceBetween,
                    modifier = Modifier.fillMaxWidth()
                ){
                    Row{
                        Text("Remember me", style = TextStyle(fontSize = 12.sp, fontWeight = FontWeight(400)))
                        Icon(imageVector = Icons.Filled.Check, contentDescription = "Remember me", modifier = Modifier.size(20.dp))
                    }
                    ClickableText(
                        text = AnnotatedString(
                            text = "Forgot Password?",
                            spanStyle = SpanStyle(
                                color = Color(0xFFF76306),
                                fontSize = 12.sp,
                                fontWeight = FontWeight.W400
                            )
                        ),
                        onClick = {}
                    )
                }
                Spacer(modifier = Modifier.height(28.dp))
                TextButton(
                    onClick = {
                        if(emailValue.value.isEmpty() || passValue.value.isEmpty()){
                            coroutineScope.launch {
                                scaffoldState.snackbarHostState.showSnackbar(
                                    message = "Fill all the fields",
                                    duration = SnackbarDuration.Short,
                                )
                            }
                            return@TextButton
                        }
                        if(!emailValue.value.contains('@')){
                            coroutineScope.launch {
                                scaffoldState.snackbarHostState.showSnackbar(
                                    message = "Enter a valid email address",
                                    duration = SnackbarDuration.Short
                                )
                            }
                            return@TextButton
                        }
                        if(passValue.value.length < 6){
                            coroutineScope.launch {
                                scaffoldState.snackbarHostState.showSnackbar(
                                    message = "Password should be atleast 6 characters long",
                                    duration = SnackbarDuration.Short
                                )
                            }
                            return@TextButton
                        }
                        viewModel.signIn(email = emailValue.value.trim(), password = passValue.value.trim())
                    },
                    shape = RoundedCornerShape(corner = CornerSize(15.dp)),
                    modifier = Modifier
                        .clip(RoundedCornerShape(corner = CornerSize(15.dp)))
                        .fillMaxWidth(0.75f)
                        .background(color = Color(0xFF9C32A6))
                ) {
                    Text(
                        text = "Login",
                        style = TextStyle(
                            color = Color.White,
                            fontSize = 18.sp,
                            fontWeight = FontWeight.W400
                        )
                    )
                    when(val response = viewModel.signInState.value){
                        is Response.Loading -> {
                            CircularProgressIndicator(
                                modifier = Modifier.fillMaxSize()
                            )
                        }
                        is Response.Success -> {
                            if (response.data) {
                                if (isStudent.value) {
                                    navController.navigate(route = "homestudent"){
                                        popUpTo(route = "login"){
                                            inclusive = true
                                        }
                                    }
                                }else{
                                    navController.navigate(route = "homeadmin"){
                                        popUpTo(route = "login"){
                                            inclusive = true
                                        }
                                    }
                                }
                            }
                            else{
                                Toast.makeText(LocalContext.current, "Sign In Failed", Toast.LENGTH_SHORT).show()
                            }
                        }
                        is Response.Error -> {
                            Toast.makeText(LocalContext.current, response.message, Toast.LENGTH_SHORT).show()
                        }
                    }
                }
                Spacer(modifier = Modifier.height(5.dp))
                Text(text = "Or", style = TextStyle(fontSize = 15.sp, fontWeight = FontWeight.W400))
                Spacer(modifier = Modifier.height(5.dp))
                TextButton(
                    onClick = { isStudent.value = !isStudent.value },
                    shape = RoundedCornerShape(corner = CornerSize(15.dp)),
                    modifier = Modifier
                        .clip(RoundedCornerShape(corner = CornerSize(15.dp)))
                        .fillMaxWidth(0.85f)
                        .border(
                            width = 1.dp,
                            color = Color(0xF9FF4FED),
                            shape = RoundedCornerShape(corner = CornerSize(15.dp))
                        )
                ) {
                    val style = TextStyle(
                        color = Color(0xFF51025E),
                        fontSize = 18.sp,
                        fontWeight = FontWeight.W400
                    )
                    if(isStudent.value){
                        Text(
                            text = "Sign-In As Admin",
                            style = style
                        )
                    }
                    else{
                        Text(
                            text = "Sign-In As Student",
                            style = style
                        )
                    }

                }
            }
        }

        Row(
            modifier = Modifier.align(Alignment.BottomCenter)
        ){
            Text(
                text = "Don't have an account?",
                style = TextStyle(
                    fontSize = 15.sp,
                    fontWeight = FontWeight(500)
                )
            )
            ClickableText(
                text = AnnotatedString(
                    text = " Create one",
                    spanStyle = SpanStyle(
                        color = Color(0xFFF76306),
                        fontSize = 15.sp,
                        fontWeight = FontWeight(500)
                    )
                ),
                onClick = {
                    if(isStudent.value){
                        navController.navigate(route = "createStudentAccount"){
                            launchSingleTop = true
                        }
                    }
                    else{
                        navController.navigate(route = "createAdminAccount"){
                            launchSingleTop = true
                        }
                    }
                })
        }

    }
}