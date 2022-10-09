package com.example.hostelite.presentation.student_screens

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.hostelite.shared.widgets.AppBar

@Composable
fun StudentReportIssue(navController: NavController){
    val expanded = remember { mutableStateOf(false)}
    val complaintCategories = listOf<String>(
        "Mess",
        "Cleanliness",
        "Maintenance",
        "Others"
    )
    val selectedComplaint = remember { mutableStateOf("")}
    val issue = remember { mutableStateOf("")}
    val icon = if(expanded.value){
        Icons.Filled.KeyboardArrowUp
    } else{
        Icons.Filled.KeyboardArrowDown
    }
    
    Scaffold(
        topBar = {AppBar(navController, "Report an Issue")}
    ) {
        Box(
            modifier = Modifier
                .padding(bottom = 40.dp)
                .fillMaxSize()
        ){
            Text(
                text = "Information about your device,account and this app will be automatically included in this report. To learn more about how your information is used,please see our Data Use Policy.",
                style = TextStyle(
                    fontSize = 10.sp,
                    fontWeight = FontWeight.W400,
                    textAlign = TextAlign.Center
                ),
                modifier = Modifier
                    .align(Alignment.BottomCenter)
                    .padding(horizontal = 40.dp)
            )
            Column(
                modifier = Modifier
                    .align(Alignment.Center)
                    .padding(vertical = 30.dp, horizontal = 30.dp),
            ) {
                Column() {
                    OutlinedTextField(
                        value = selectedComplaint.value,
                        readOnly = true,
                        onValueChange = { selectedComplaint.value = it },
                        label = @Composable() { Text(text = "Your issue..") },
                        singleLine = true,
                        modifier = Modifier.fillMaxWidth(),
                        trailingIcon = {
                            Icon(
                                imageVector = icon,
                                contentDescription = null,
                                modifier = Modifier.clickable { expanded.value = !expanded.value }
                            )
                        }
                    )
                    DropdownMenu(
                        expanded = expanded.value,
                        onDismissRequest = { expanded.value = false },
                        modifier = Modifier.fillMaxWidth(0.5f)
                    ) {
                        complaintCategories.forEach { label ->
                            DropdownMenuItem(onClick = {
                                selectedComplaint.value = label
                                expanded.value = false
                            }) {
                                Text(text = label)
                            }
                        }
                    }   
                }
                Spacer(modifier = Modifier.height(40.dp))
                OutlinedTextField(
                    value = issue.value,
                    onValueChange = {issue.value = it},
                    placeholder = { Text("Type an explanation...") },
                    maxLines = 50,
                    modifier = Modifier
                        .defaultMinSize(minHeight = 200.dp)
                        .fillMaxWidth()
                )
                Spacer(modifier = Modifier.height(30.dp))
                TextButton(
                    onClick = { /*TODO*/ },
                    modifier = Modifier
                        .width(140.dp)
                        .height(40.dp)
                        .clip(RoundedCornerShape(corner = CornerSize(10.dp)))
                        .background(color = Color(0xFFCBCDFF))
                ) {
                    Text(
                        text = "Upload Image",
                        style = TextStyle(
                            color = Color(0xFF1C48E7),
                            fontSize = 14.sp,
                            fontWeight = FontWeight.W500
                        )
                    )
                }
                Spacer(modifier = Modifier.height(60.dp))
                Row(
                    horizontalArrangement = Arrangement.End,
                    modifier = Modifier.fillMaxWidth()
                ){
                    TextButton(
                        onClick = { /*TODO*/ },
                        modifier = Modifier
                            .width(150.dp)
                            .height(50.dp)
                            .clip(RoundedCornerShape(corner = CornerSize(10.dp)))
                            .background(color = Color(0xFFFE96FA))
                    ) {
                        Text(
                            text = "Send",
                            style = TextStyle(
                                color = Color(0xFF33004A),
                                fontSize = 24.sp,
                                fontWeight = FontWeight.W500
                            )
                        )
                    }
                }
            }
        }
    }
}
