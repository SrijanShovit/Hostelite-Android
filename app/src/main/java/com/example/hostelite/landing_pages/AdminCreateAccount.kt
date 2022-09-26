package com.example.hostelite.landing_pages

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.ClickableText
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.material.TextButton
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBackIos
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun AdminCreateAccount() {
    val formValues = listOf<MutableState<String>>(
        remember { mutableStateOf("") },
        remember { mutableStateOf("") },
        remember { mutableStateOf("") },
        remember { mutableStateOf("") },
        remember { mutableStateOf("") }
    )

    Box(
        modifier = Modifier.fillMaxSize()
    ) {
        IconButton(
            onClick = { /*TODO*/ },
            modifier = Modifier.padding(10.dp)
        ) {
            Icon(imageVector = Icons.Filled.ArrowBackIos, contentDescription = "Go back")
        }

        Row(
            modifier = Modifier.align(Alignment.BottomCenter)
        ) {
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
                onClick = {})
        }

        Column(
            modifier = Modifier
                .align(Alignment.TopCenter)
                .padding(top = 20.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
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
            ) {
                FormInputBox(key = formValues[0], label = "Username")
                Spacer(modifier = Modifier.height(5.dp))
                FormInputBox(key = formValues[1], label = "Email", email = true)
                Spacer(modifier = Modifier.height(5.dp))
                FormInputBox(key = formValues[2], label = "Mobile Number")
                Spacer(modifier = Modifier.height(5.dp))
                FormPasswordBox(key = formValues[3], label = "Create Password")
                Spacer(modifier = Modifier.height(5.dp))
                FormPasswordBox(key = formValues[4], label = "Confirm Password")
                Spacer(modifier = Modifier.height(5.dp))
            }
            Spacer(modifier = Modifier.height(70.dp))
            TextButton(
                onClick = { /*TODO*/ },
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
