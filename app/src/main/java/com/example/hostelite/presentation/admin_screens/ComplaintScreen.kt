package com.example.hostelite.presentation.admin_screens

import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDownward
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.hostelite.R
import com.example.hostelite.shared.widgets.AppBar
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.HorizontalPager
import com.google.accompanist.pager.rememberPagerState
import kotlinx.coroutines.launch

private data class Complaint(
    val name: String,
    val dpUrl: Int,
    val roomNo: String,
    val title: String,
    val date: String,
    val imgUrl: Int,
    val complaintText: String,
    val status: String,
    val time: String
)

@OptIn(ExperimentalPagerApi::class)
@Composable
fun ComplaintScreen(navController: NavController){
    val expanded = remember { mutableStateOf(false) }
    val selectedCategory : MutableState<String?> = remember { mutableStateOf(null)}

    val complaints : MutableList<Complaint> = mutableListOf(
        Complaint(
            name = "Ramesh Kumar",
            dpUrl = R.drawable.dp1,
            roomNo = "2-3",
            title = "Unhygienic Food",
            date = "26/11/2022",
            imgUrl = R.drawable.badfood,
            complaintText = "Hello Sir, the food quality is steeply degrading day by day that is affecting our health also . The rotis are much hard to chew and also they don’t serve hot roties and in paneer ki sabji we are hardy able to find pieces of paneer. it is my immediate request please fix these problems as soon as possible.",
            status = "Sorted",
            time = "08:45 PM"
        ),
        Complaint(
            name = "Ramesh Kumar",
            dpUrl = R.drawable.dp1,
            roomNo = "2-3",
            title = "Unhygienic Food",
            date = "26/11/2022",
            imgUrl = R.drawable.badfood,
            complaintText = "Hello Sir, the food quality is steeply degrading day by day that is affecting our health also . The rotis are much hard to chew and also they don’t serve hot roties and in paneer ki sabji we are hardy able to find pieces of paneer. it is my immediate request please fix these problems as soon as possible.",
            status = "Pending",
            time = "08:45 PM"
        ),
        Complaint(
            name = "Ramesh Kumar",
            dpUrl = R.drawable.dp1,
            roomNo = "2-3",
            title = "Unhygienic Food",
            date = "26/11/2022",
            imgUrl = R.drawable.badfood,
            complaintText = "Hello Sir, the food quality is steeply degrading day by day that is affecting our health also . The rotis are much hard to chew and also they don’t serve hot roties and in paneer ki sabji we are hardy able to find pieces of paneer. it is my immediate request please fix these problems as soon as possible.",
            status = "Rejected",
            time = "08:45 PM"
        ),
        Complaint(
            name = "Ramesh Kumar",
            dpUrl = R.drawable.dp1,
            roomNo = "2-3",
            title = "Unhygienic Food",
            date = "26/11/2022",
            imgUrl = R.drawable.badfood,
            complaintText = "Hello Sir, the food quality is steeply degrading day by day that is affecting our health also . The rotis are much hard to chew and also they don’t serve hot roties and in paneer ki sabji we are hardy able to find pieces of paneer. it is my immediate request please fix these problems as soon as possible.",
            status = "Pending",
            time = "08:45 PM"
        ),
        Complaint(
            name = "Ramesh Kumar",
            dpUrl = R.drawable.dp1,
            roomNo = "2-3",
            title = "Unhygienic Food",
            date = "26/11/2022",
            imgUrl = R.drawable.badfood,
            complaintText = "Hello Sir, the food quality is steeply degrading day by day that is affecting our health also . The rotis are much hard to chew and also they don’t serve hot roties and in paneer ki sabji we are hardy able to find pieces of paneer. it is my immediate request please fix these problems as soon as possible.",
            status = "Rejected",
            time = "08:45 PM"
        ),
        Complaint(
            name = "Ramesh Kumar",
            dpUrl = R.drawable.dp1,
            roomNo = "2-3",
            title = "Unhygienic Food",
            date = "26/11/2022",
            imgUrl = R.drawable.badfood,
            complaintText = "Hello Sir, the food quality is steeply degrading day by day that is affecting our health also . The rotis are much hard to chew and also they don’t serve hot roties and in paneer ki sabji we are hardy able to find pieces of paneer. it is my immediate request please fix these problems as soon as possible.",
            status = "Pending",
            time = "08:45 PM"
        ),
        Complaint(
            name = "Ramesh Kumar",
            dpUrl = R.drawable.dp1,
            roomNo = "2-3",
            title = "Unhygienic Food",
            date = "26/11/2022",
            imgUrl = R.drawable.badfood,
            complaintText = "Hello Sir, the food quality is steeply degrading day by day that is affecting our health also . The rotis are much hard to chew and also they don’t serve hot roties and in paneer ki sabji we are hardy able to find pieces of paneer. it is my immediate request please fix these problems as soon as possible.",
            status = "Sorted",
            time = "08:45 PM"
        ),
        Complaint(
            name = "Ramesh Kumar",
            dpUrl = R.drawable.dp1,
            roomNo = "2-3",
            title = "Unhygienic Food",
            date = "26/11/2022",
            imgUrl = R.drawable.badfood,
            complaintText = "Hello Sir, the food quality is steeply degrading day by day that is affecting our health also . The rotis are much hard to chew and also they don’t serve hot roties and in paneer ki sabji we are hardy able to find pieces of paneer. it is my immediate request please fix these problems as soon as possible.",
            status = "Sorted",
            time = "08:45 PM"
        ),

    )
    val pagerState = rememberPagerState(initialPage = 0)

    val coroutineScope = rememberCoroutineScope()

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
                            color = Color(0xFF4BB227),
                            textDecoration = if(pagerState.currentPage == 0){
                                TextDecoration.Underline
                            }else{
                                TextDecoration.None
                            }
                        ),
                        modifier = Modifier.clickable {
                            coroutineScope.launch {
                                pagerState.animateScrollToPage(page = 0)
                            }
                        }
                    )
                    Text(
                        text = "Pending",
                        style = TextStyle(
                            fontSize = 14.sp,
                            fontWeight = FontWeight.W500,
                            color = Color(0xFFFBC02D),
                            textDecoration = if(pagerState.currentPage == 1){
                                TextDecoration.Underline
                            }else{
                                TextDecoration.None
                            }
                        ),
                        modifier = Modifier.clickable {
                            coroutineScope.launch {
                                pagerState.animateScrollToPage(page = 1)
                            }
                        }
                    )
                    Text(
                        text = "Rejected",
                        style = TextStyle(
                            fontSize = 14.sp,
                            fontWeight = FontWeight.W500,
                            color = Color(0xFFFF4646),
                            textDecoration = if(pagerState.currentPage == 2){
                                TextDecoration.Underline
                            }else{
                                TextDecoration.None
                            }
                        ),
                        modifier = Modifier.clickable {
                            coroutineScope.launch {
                                pagerState.animateScrollToPage(page = 2)
                            }
                        }
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
                    fontSize = 14.sp,
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
                        text = selectedCategory.value ?: "Category",
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
            Spacer(modifier = Modifier.height(10.dp))
            HorizontalPager(count = 3, state = pagerState) {
                page ->
                    when(page) {
                        0 -> {
                            LazyColumn(){
                                items(complaints) {
                                    complaint ->
                                        if (complaint.status.equals("Sorted", ignoreCase = true)){
                                            ComplaintCard(complaint = complaint)
                                        }
                                }
                            }
                        }
                        1 -> {
                            LazyColumn(){
                                items(complaints) {
                                    complaint ->
                                    if (complaint.status.equals("Pending", ignoreCase = true)){
                                        ComplaintCard(complaint = complaint)
                                    }
                                }
                            }
                        }
                        2 -> {
                            LazyColumn(){
                                items(complaints) {
                                    complaint ->
                                    if (complaint.status.equals("Rejected", ignoreCase = true)){
                                        ComplaintCard(complaint = complaint)
                                    }
                                }
                            }
                        }
                    }
            }

        }
    }
}

@Composable
private fun ComplaintCard(complaint: Complaint) {
    Surface(
        modifier = Modifier
            .padding(horizontal = 15.dp, vertical = 20.dp)
            .fillMaxWidth(),
        elevation = 7.dp,
        color = Color.White,
        shape = RoundedCornerShape(corner = CornerSize(size = 15.dp)),
        border = BorderStroke(width = 0.5.dp, color = Color(0xFFC1C1C1))
    ){
        Column(
            modifier = Modifier.padding(all = 5.dp),
        ){
            Row(
                modifier = Modifier
                    .padding(vertical = 2.dp)
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ){
                Row(
                    verticalAlignment = Alignment.CenterVertically
                ){
                    Image(
                        painter = painterResource(id = complaint.dpUrl),
                        contentDescription = null,
                        modifier = Modifier
                            .size(size = 34.dp)
                            .clip(shape = CircleShape)
                    )
                    Spacer(modifier = Modifier.width(10.dp))
                    Column(
                        horizontalAlignment = Alignment.Start,
                        verticalArrangement = Arrangement.SpaceEvenly
                    ){
                        Text(
                            text = complaint.name,
                            style = TextStyle(
                                fontSize = 18.sp,
                                color = Color(0xFF565656),
                                fontWeight = FontWeight.W500
                            )
                        )
                        Text(
                            text = "Room no: ${complaint.roomNo}",
                            style = TextStyle(
                                fontSize = 12.sp,
                                color = Color(0xFF666666),
                                fontWeight = FontWeight.W400
                            )
                        )
                    }
                }
                Text(
                    text = complaint.date,
                    style = TextStyle(
                        color = Color(0xFF9F9F9F),
                        fontSize = 16.sp,
                        fontWeight = FontWeight.W400
                    )
                )
            }
            Spacer(modifier = Modifier.height(10.dp))
            Divider(
                modifier = Modifier
                    .padding(horizontal = 5.dp)
                    .fillMaxWidth(),
                thickness = 1.dp,
                color = Color(0xFFC1C1C1)
            )
            Image(
                painter = painterResource(id = complaint.imgUrl),
                contentDescription = "Image for complaint",
                contentScale = ContentScale.Fit,
                modifier = Modifier
                    .padding(horizontal = 20.dp, vertical = 5.dp)
                    .height(240.dp)
                    .fillMaxWidth()
                    .clip(shape = RoundedCornerShape(corner = CornerSize(size = 10.dp)))
            )
            Text(
                text = complaint.title,
                style = TextStyle(
                    fontSize = 18.sp,
                    fontWeight = FontWeight.W500,
                    color = Color(0xFF565656)
                ),
                modifier = Modifier
                    .padding(horizontal = 20.dp, vertical = 2.dp)
                    .fillMaxWidth()
            )
            Text(
                text = complaint.complaintText,
                style = TextStyle(
                    color = Color(0xFF595858),
                    fontSize = 16.sp,
                    fontWeight = FontWeight.W400
                ),
                modifier = Modifier
                    .padding(all = 20.dp)
                    .fillMaxWidth()
            )
            Row(
                horizontalArrangement = Arrangement.SpaceBetween,
                modifier = Modifier
                    .padding(all = 5.dp)
                    .fillMaxWidth()
            ) {
                Spacer(modifier = Modifier.width(10.dp))
                Text(
                    text = complaint.time,
                    style = TextStyle(
                        fontSize = 16.sp,
                        fontWeight = FontWeight.W400,
                        color = Color(0xFF9F9F9F)
                    )
                )
            }
            if(complaint.status.equals("Pending", ignoreCase = true)){
                Spacer(modifier = Modifier.height(10.dp))
                Row(
                    modifier = Modifier
                        .padding(horizontal = 30.dp, vertical = 10.dp)
                        .fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ){
                    Text(
                        text = "Reject",
                        style = TextStyle(
                            fontSize = 16.sp,
                            fontWeight = FontWeight.W500,
                            color = Color(0xFFFF4646)
                        ),
                        modifier = Modifier.clickable {  }
                    )
                    Row(
                        modifier = Modifier
                            .width(120.dp)
                            .height(40.dp)
                            .clip(shape = RoundedCornerShape(corner = CornerSize(size = 10.dp)))
                            .background(color = Color(0xFFDFFED4))
                            .clickable {}
                            .border(
                                width = 1.dp,
                                color = Color(0xFF4BB227),
                                shape = RoundedCornerShape(corner = CornerSize(size = 10.dp))
                            ),
                        horizontalArrangement = Arrangement.Center,
                        verticalAlignment = Alignment.CenterVertically
                    ){
                        Text(
                            text = "Mark Sorted",
                            style = TextStyle(
                                fontSize = 16.sp,
                                fontWeight = FontWeight.W500,
                                color = Color(0xFF4BB227)
                            )
                        )
                    }
                }
            }
        }
    }
}