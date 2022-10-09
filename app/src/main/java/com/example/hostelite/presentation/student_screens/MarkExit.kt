package com.example.hostelite.presentation.student_screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.hostelite.R
import com.example.hostelite.shared.widgets.AppBar

@Composable
fun MarkExit(navController: NavController) {
    val reason = remember { mutableStateOf("") }
    Scaffold(
        topBar = { AppBar(navController = navController, text = "Mark Exit") }
    ) {
        Box(
            modifier = Modifier.fillMaxSize()
        ) {
            Image(
                painter = painterResource(id = R.drawable.bg),
                contentDescription = null,
                modifier = Modifier
                    .align(Alignment.Center)
                    .padding(20.dp)
                    .fillMaxSize()
            )
            Image(
                painter = painterResource(id = R.drawable.hostellite),
                contentDescription = null,
                modifier = Modifier
                    .align(Alignment.BottomCenter)
                    .padding(bottom = 20.dp)
                    .fillMaxWidth()
            )
            Column(
                modifier = Modifier
                    .align(Alignment.Center)
                    .padding(horizontal = 20.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                OutlinedTextField(
                    value = reason.value,
                    onValueChange = { reason.value = it },
                    singleLine = true,
                    placeholder = { Text(text = "Purpose of Exit") },
                    modifier = Modifier
                        .fillMaxWidth()
                        .clip(shape = RoundedCornerShape(corner = CornerSize(20.dp)))
                        .background(color = Color(0xFFF7F7F7)),
                    shape = RoundedCornerShape(corner = CornerSize(20.dp))
                )
                Spacer(modifier = Modifier.height(150.dp))
                Row(
                    modifier = Modifier
                        .height(50.dp)
                        .width(160.dp)
                        .clip(shape = RoundedCornerShape(corner = CornerSize(size = 15.dp)))
                        .background(color = Color(0xFFFE96FA))
                        .clickable { /* Todo */ },
                    horizontalArrangement = Arrangement.Center,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        text = "Mark Exit",
                        style = TextStyle(
                            fontSize = 20.sp,
                            fontWeight = FontWeight.W400,
                            color = Color(0xFF33004A)
                        )
                    )
                }
            }
        }
    }
}