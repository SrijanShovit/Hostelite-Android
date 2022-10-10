package com.example.hostelite.presentation.student_screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.ArrowBackIos
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.hostelite.R

@Composable
fun EditStudentProfile(navController: NavController){
    val fields : List<Pair<MutableState<String>, String>> = listOf(
        Pair(remember { mutableStateOf("")}, "Name"),
        Pair(remember { mutableStateOf("")}, "E-mail"),
        Pair(remember { mutableStateOf("")}, "Mobile No."),
        Pair(remember { mutableStateOf("")}, "Roll No.")
    )
    Box(modifier = Modifier.fillMaxSize()){
        IconButton(
            onClick = { navController.popBackStack() },
            modifier = Modifier
                .padding(all = 10.dp)
                .align(Alignment.TopStart)) {
            Icon(imageVector = Icons.Filled.ArrowBackIos, contentDescription = null)
        }
        Text(
            text = "Edit Profile",
            style = TextStyle(
                fontSize = 28.sp,
                fontWeight = FontWeight.W700,
                color = Color(0xFF868686)
            ),
            modifier = Modifier.padding(vertical = 10.dp).align(Alignment.TopCenter)
        )
        Column(
            modifier = Modifier
                .padding(horizontal = 30.dp, vertical = 20.dp)
                .fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ){
            Box(
                modifier = Modifier
                    .height(150.dp)
                    .width(150.dp)
            ){
                Image(
                    painter = painterResource(id = R.drawable.defaultdp),
                    contentDescription = "Add Photo",
                    colorFilter = ColorFilter.tint(color = Color.Black),
                    modifier = Modifier
                        .align(Alignment.Center)
                        .size(150.dp)
                        .clip(CircleShape)
                        .border(width = 5.dp, color = Color.Black, shape = CircleShape),
                    contentScale = ContentScale.Fit
                )
                IconButton(
                    onClick = { /*TODO*/ },
                    modifier = Modifier
                        .align(Alignment.TopEnd)
                        .size(30.dp)
                        .clip(CircleShape)
                        .background(color = Color.White)
                        .border(width = 1.dp, color = Color.Gray, shape = CircleShape)
                ) {
                    Icon(imageVector = Icons.Filled.Add, contentDescription = null)
                }
            }
            Spacer(modifier = Modifier.height(50.dp))
            fields.forEach { 
                field -> EditProfileField(field = field.first, label = field.second)
            }
        }
        Row(
            modifier = Modifier
                .padding(bottom = 20.dp)
                .align(Alignment.BottomCenter)
                .width(150.dp)
                .height(50.dp)
                .clip(RoundedCornerShape(corner = CornerSize(size = 15.dp)))
                .clickable {  }
                .background(color = Color(0xFFCA48D6)),
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically
        ){
            Text(
                text = "Save",
                style = TextStyle(
                    fontSize = 22.sp,
                    fontWeight = FontWeight.W700,
                    color = Color.White
                )
            )
        }
    }
}

@Composable
private fun EditProfileField(field: MutableState<String>, label: String){
    OutlinedTextField(
        value = field.value,
        onValueChange = {field.value = it},
        shape = RoundedCornerShape(corner = CornerSize(size = 20.dp)),
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 5.dp),
        label = {
            Text(
                text = label,
                style = TextStyle(
                    fontSize = 16.sp,
                    fontWeight = FontWeight.W500,
                    color = Color(0xFF7A7A7A)
                )
            )
        },
        textStyle = TextStyle(
            fontSize = 24.sp,
            fontWeight = FontWeight.W500,
            color = Color(0xFFB1B1B1)
        ),
        singleLine = true,
    )
}