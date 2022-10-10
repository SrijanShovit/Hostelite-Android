package com.example.hostelite.presentation.student_screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Menu
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.hostelite.R
import com.example.hostelite.shared.widgets.AppBar
import com.example.hostelite.shared.widgets.BottomDrawer
import com.google.accompanist.pager.ExperimentalPagerApi

data class MyComplaint(
    val title: String,
    val date: String,
    val imgUrl: Int,
    val complaintText: String,
    val status: String,
    val time: String
)
@Composable
fun MyComplaints(navController: NavController){

    val isEnabled1 = remember { mutableStateOf(false)}
    val isEnabled2 = remember { mutableStateOf(false)}
    val sortKey : MutableState<String?> = remember { mutableStateOf(null)}

    val myComplaints : MutableList<MyComplaint> = mutableListOf(
        MyComplaint(
            title = "Food Quality",
            date = "14.05.2021",
            imgUrl = R.drawable.badfood,
            complaintText = "Hello Sir, the food quality is steeply degrading day by day that is affecting our health also . The rotis are much hard to chew and also they don’t serve hot roties and in paneer ki sabji we are hardy able to find pieces of paneer. it is my immediate request please fix these problems as soon as possible.",
            status = "Sorted",
            time = "08:45 PM"
        ),
        MyComplaint(
            title = "Food Quality",
            date = "29.05.2021",
            imgUrl = R.drawable.badfood,
            complaintText = "Hello Sir, the food quality is steeply degrading day by day that is affecting our health also . The rotis are much hard to chew and also they don’t serve hot roties and in paneer ki sabji we are hardy able to find pieces of paneer. it is my immediate request please fix these problems as soon as possible.",
            status = "Pending",
            time = "08:45 PM"
        ),
        MyComplaint(
            title = "Food Quality",
            date = "30.05.2021",
            imgUrl = R.drawable.badfood,
            complaintText = "Hello Sir, the food quality is steeply degrading day by day that is affecting our health also . The rotis are much hard to chew and also they don’t serve hot roties and in paneer ki sabji we are hardy able to find pieces of paneer. it is my immediate request please fix these problems as soon as possible.",
            status = "Rejected",
            time = "08:45 PM"
        ),
    )

    Scaffold(
        topBar = { AppBar(navController = navController, text = "Your Complaint Status")},
        bottomBar = { BottomDrawer(navController = navController, isStudent = true)}
    ) {
        Column(
            modifier = Modifier.padding(horizontal = 30.dp, vertical = 24.dp)
        ){
            Row(
                horizontalArrangement = Arrangement.SpaceBetween,
                modifier = Modifier.fillMaxWidth()
            ){
                val textStyle = TextStyle(
                    fontSize = 16.sp,
                    fontWeight = FontWeight.W400,
                    color = Color(0xFF666666)
                )
                Spacer(modifier = Modifier.width(10.dp))
                Row(
                    modifier = Modifier
                        .width(width = 120.dp)
                        .height(height = 35.dp)
                        .clip(shape = RoundedCornerShape(corner = CornerSize(size = 15.dp)))
                        .border(
                            width = 1.dp,
                            color = Color(0xFFE1E1E1),
                            shape = RoundedCornerShape(corner = CornerSize(size = 15.dp))
                        )
                        .clickable { isEnabled1.value = true },
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.Center
                ){
                    Icon(
                        imageVector = Icons.Outlined.Menu,
                        contentDescription = "Filter Complaints",
                        modifier = Modifier.size(size = 20.dp),
                        tint = Color(0xFF8B8B8B)
                    )
                    Spacer(modifier = Modifier.width(10.dp))
                    Text(
                        text = sortKey.value ?: "Sort By",
                        style = TextStyle(
                            fontSize = 18.sp,
                            fontWeight = FontWeight.W500,
                            color = Color(0xFF8B8B8B)
                        )
                    )
                    DropdownMenu(expanded = isEnabled1.value, onDismissRequest = { isEnabled1.value = false }) {
                        DropdownMenuItem(onClick = {
                            sortKey.value = "Alphabet"
                            isEnabled1.value = false
                        }) {
                            Text(
                                text = "Alphabet",
                                style = textStyle
                            )
                        }
                        DropdownMenuItem(onClick = {
                            sortKey.value = "Date"
                            isEnabled1.value = false
                        }) {
                            Text(
                                text = "Date",
                                style = textStyle
                            )
                        }
                        DropdownMenuItem(onClick = {
                            isEnabled2.value = true
                            isEnabled1.value = false
                        }) {
                            Text(
                                text = "Status",
                                style = textStyle
                            )
                        }
                        DropdownMenuItem(onClick = {
                            isEnabled1.value = false
                            sortKey.value = null
                        }) {
                            Text(
                                text = "Clear",
                                style = textStyle
                            )
                        }
                    }
                    DropdownMenu(expanded = isEnabled2.value, onDismissRequest = { isEnabled2.value = false }) {
                        DropdownMenuItem(onClick = {
                            sortKey.value = "Sorted"
                            isEnabled2.value = false
                        }) {
                            Text(
                                text = "Sorted",
                                style = textStyle
                            )
                        }
                        DropdownMenuItem(onClick = {
                            sortKey.value = "Pending"
                            isEnabled2.value = false
                        }) {
                            Text(
                                text = "Pending",
                                style = textStyle
                            )
                        }
                        DropdownMenuItem(onClick = {
                            sortKey.value = "Rejected"
                            isEnabled2.value = false
                        }) {
                            Text(
                                text = "Rejected",
                                style = textStyle
                            )
                        }
                    }
                }
            }
            Spacer(modifier = Modifier.height(25.dp))
            LazyColumn(
                modifier = Modifier.fillMaxSize(),
                contentPadding = PaddingValues(vertical = 10.dp)
            ) {
                items(myComplaints) { myComplaint ->
                    MyComplaintCard(myComplaint)
                }
            }
        }
    }
}

@Composable
private fun MyComplaintCard(myComplaint: MyComplaint) {
    Surface(
        modifier = Modifier.fillMaxWidth().padding(vertical = 20.dp),
        shape = RoundedCornerShape(corner = CornerSize(size = 10.dp)),
        elevation = 10.dp,
        color = Color.White
    ) {
        Column(
            modifier = Modifier.fillMaxWidth()
        ){
            Row(
                modifier = Modifier
                    .padding(horizontal = 20.dp, vertical = 10.dp)
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ){
                Text(
                    text = myComplaint.title,
                    style = TextStyle(
                        fontSize = 18.sp,
                        fontWeight = FontWeight.W500,
                        color = Color(0xFF565656)
                    )
                )
                Text(
                    text = myComplaint.date,
                    style = TextStyle(
                        fontSize = 16.sp,
                        fontWeight = FontWeight.W400,
                        color = Color(0xFF9F9F9F)
                    )
                )
            }
            Divider(
                modifier = Modifier.fillMaxWidth(),
                color = Color(0xFFC1C1C1),
                thickness = 1.dp
            )
            Image(
                painter = painterResource(id = myComplaint.imgUrl),
                contentDescription = "Image for complaint",
                contentScale = ContentScale.Fit,
                modifier = Modifier
                    .padding(horizontal = 20.dp, vertical = 5.dp)
                    .height(240.dp)
                    .fillMaxWidth()
                    .clip(shape = RoundedCornerShape(corner = CornerSize(size = 10.dp)))
            )
            Text(
                modifier = Modifier
                    .padding(horizontal = 20.dp)
                    .fillMaxWidth(),
                text = myComplaint.complaintText,
                style = TextStyle(
                    fontSize = 15.sp,
                    fontWeight = FontWeight.W400,
                    color = Color(0xFF5C5C5C)
                )
            )
            Row(
                modifier = Modifier
                    .padding(horizontal = 20.dp, vertical = 10.dp)
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ){
                Row(
                    verticalAlignment = Alignment.CenterVertically
                ){
                    var statusColor: Color = Color(0xFF4BB227)
                    if(myComplaint.status == "Pending"){
                        statusColor = Color(0xFFFBC02D)
                    }
                    else if(myComplaint.status == "Rejected"){
                        statusColor = Color(0xFFFF4646)
                    }
                    Text(
                        text = "Status :",
                        style = TextStyle(
                            fontSize = 15.sp,
                            fontWeight = FontWeight.W400
                        )
                    )
                    Spacer(modifier = Modifier.width(10.dp))
                    Text(
                        text = myComplaint.status,
                        style = TextStyle(
                            fontSize = 16.sp,
                            fontWeight = FontWeight.W500,
                            color = statusColor
                        )
                    )
                }
                Text(
                    text = myComplaint.time,
                    style = TextStyle(
                        fontSize = 14.sp,
                        fontWeight = FontWeight.W400,
                        color = Color(0xFF9F9F9F)
                    )
                )
            }
        }
    }
}

@OptIn(ExperimentalPagerApi::class)
@Composable
private fun ComplaintPager(){

}