package com.example.hostelite.admin_screens

import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDownward
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.hostelite.shared.widgets.AppBar

@Composable
fun ComplaintScreen(navController: NavController){
    val expanded = remember { mutableStateOf(false) }
    val selectedCategory : MutableState<String?> = remember { mutableStateOf(null)}
    Scaffold(
        topBar = { AppBar(navController = navController, text = "View Complaints")}
    ) {
        Column(
            modifier = Modifier.fillMaxSize()
        ) {
            Surface(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(50.dp),
                elevation = 5.dp,
                color = Color.White,
                shape = RoundedCornerShape(bottomStart = 15.dp, bottomEnd = 15.dp)
            ){
                Row(
                    modifier = Modifier
                        .padding(horizontal = 30.dp, vertical = 10.dp),
                    horizontalArrangement = Arrangement.SpaceEvenly,
                    verticalAlignment = Alignment.CenterVertically
                ){
                    Text(
                        text = "Status : ",
                        style = TextStyle(
                            fontSize = 14.sp,
                            fontWeight = FontWeight.W400,
                        )
                    )
                    Text(
                        text = "Sorted",
                        style = TextStyle(
                            fontSize = 14.sp,
                            fontWeight = FontWeight.W500,
                            color = Color(0xFF4BB227)
                        )
                    )
                    Text(
                        text = "Pending",
                        style = TextStyle(
                            fontSize = 14.sp,
                            fontWeight = FontWeight.W500,
                            color = Color(0xFFFBC02D)
                        )
                    )
                    Text(
                        text = "Rejected",
                        style = TextStyle(
                            fontSize = 14.sp,
                            fontWeight = FontWeight.W500,
                            color = Color(0xFFFF4646)
                        )
                    )
                }
            }
            Spacer(modifier = Modifier.height(10.dp))
            Row(
                modifier = Modifier
                    .padding(horizontal = 25.dp)
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
            ){
                Spacer(modifier = Modifier.width(10.dp))
                val textStyle = TextStyle(
                    fontSize = 12.sp,
                    color = Color(0xFF9D9D9D),
                    fontWeight = FontWeight.W400
                )
                Row(
                    modifier = Modifier
                        .border(
                            width = 1.dp,
                            color = Color(0xFFB7B7B7),
                            shape = RoundedCornerShape(corner = CornerSize(size = 12.dp))
                        )
                        .padding(all = 5.dp)
                        .clickable { expanded.value = !expanded.value },
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ){
                    Text(
                        text = selectedCategory.value ?: "Hostel",
                        style = textStyle
                    )
                    Spacer(modifier = Modifier.width(10.dp))
                    Icon(
                        imageVector = Icons.Filled.ArrowDownward,
                        contentDescription = "Category",
                        modifier = Modifier.size(size = 10.dp)
                    )
                    DropdownMenu(
                        expanded = expanded.value,
                        onDismissRequest = { expanded.value = false }
                    ) {
                        val textStyle = TextStyle(
                            fontSize = 18.sp,
                            color = Color(0xFF8B8B8B),
                            fontWeight = FontWeight.W500
                        )
                        DropdownMenuItem(
                            onClick = {
                                selectedCategory.value = "Infrastructure"
                                expanded.value = false
                            }
                        ) {
                            Text(
                                text = "Infrastructure",
                                style = textStyle
                            )
                        }
                        DropdownMenuItem(
                            onClick = {
                                selectedCategory.value = "Food"
                                expanded.value = false
                            }
                        ) {
                            Text(
                                text = "Food",
                                style = textStyle
                            )
                        }
                        DropdownMenuItem(
                            onClick = {
                                selectedCategory.value = "Wifi"
                                expanded.value = false
                            }
                        ) {
                            Text(
                                text = "Wifi",
                                style = textStyle
                            )
                        }
                        DropdownMenuItem(onClick = {
                            selectedCategory.value = "Sanitation"
                            expanded.value = false
                        }) {
                            Text(
                                text = "Sanitation",
                                style = textStyle
                            )
                        }
                        DropdownMenuItem(onClick = {
                            selectedCategory.value = "Water"
                            expanded.value = false
                        }) {
                            Text(
                                text = "Water",
                                style = textStyle
                            )
                        }
                        DropdownMenuItem(onClick = {
                            selectedCategory.value = "Electricity"
                            expanded.value = false
                        }) {
                            Text(
                                text = "Electricity",
                                style = textStyle
                            )
                        }
                        DropdownMenuItem(onClick = {
                            selectedCategory.value = null
                            expanded.value = false
                        }) {
                            Text(
                                text = "Clear",
                                style = textStyle
                            )
                        }
                    }
                }
            }
        }
    }
}