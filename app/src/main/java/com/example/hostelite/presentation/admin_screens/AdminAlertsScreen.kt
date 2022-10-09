package com.example.hostelite.presentation.admin_screens

import android.app.DatePickerDialog
import android.widget.DatePicker
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
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
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.hostelite.R
import com.example.hostelite.shared.widgets.AppBar
import java.util.*

private data class StudentAlert(
    val dpUrl: Int,
    val studentName: String,
    val roomNo: String,
    val date: String,
    val message: String,
    val time: String
)

@Composable
fun AdminAlertsScreen(navController: NavController){
    val context = LocalContext.current
    val studentAlerts: MutableList<StudentAlert> = mutableListOf(
        StudentAlert(
            dpUrl = R.drawable.dp1,
            studentName = "Ramesh Kumar",
            roomNo = "08",
            date = "14.05.2021",
            message = "Sir I went to purchase a book, but while returning it started raining. So there was no any option left for me than to wait at the store until the rain stopped.",
            time = "08:45 PM"
        ),
        StudentAlert(
            dpUrl = R.drawable.dp1,
            studentName = "Ramesh Kumar",
            roomNo = "08",
            date = "14.05.2021",
            message = "Sir I went to purchase a book, but while returning it started raining. So there was no any option left for me than to wait at the store until the rain stopped.",
            time = "08:45 PM"
        ),
        StudentAlert(
            dpUrl = R.drawable.dp1,
            studentName = "Ramesh Kumar",
            roomNo = "08",
            date = "14.05.2021",
            message = "Sir I went to purchase a book, but while returning it started raining. So there was no any option left for me than to wait at the store until the rain stopped.",
            time = "08:45 PM"
        ),
        StudentAlert(
            dpUrl = R.drawable.dp1,
            studentName = "Ramesh Kumar",
            roomNo = "08",
            date = "14.05.2021",
            message = "Sir I went to purchase a book, but while returning it started raining. So there was no any option left for me than to wait at the store until the rain stopped.",
            time = "08:45 PM"
        ),
        StudentAlert(
            dpUrl = R.drawable.dp1,
            studentName = "Ramesh Kumar",
            roomNo = "08",
            date = "14.05.2021",
            message = "Sir I went to purchase a book, but while returning it started raining. So there was no any option left for me than to wait at the store until the rain stopped.",
            time = "08:45 PM"
        ),
    )
    val expanded = remember { mutableStateOf(false) }
    val selectedHostel: MutableState<String?> = remember { mutableStateOf(null) }

    val mCalendar = Calendar.getInstance()
    val year: Int = mCalendar.get(Calendar.YEAR)
    val month: Int = mCalendar.get(Calendar.MONTH)
    val day: Int = mCalendar.get(Calendar.DAY_OF_MONTH)
    val selectedDate: MutableState<String> = remember { mutableStateOf(value = "$day/${month+1}/$year") }

    mCalendar.time = Date()

    val mDatePickerDialog = DatePickerDialog(
        context,
        { _: DatePicker, mYear: Int, mMonth: Int, mDayOfMonth: Int ->
            selectedDate.value = "$mDayOfMonth/${mMonth+1}/$mYear"
        }, year, month, day
    )

    Scaffold(
        topBar = { AppBar(navController = navController, text = "Alerts") },
        bottomBar = { com.example.hostelite.shared.widgets.BottomDrawer(
            navController = navController,
            isStudent = false
        )}
    ) {
        Column(
            modifier = Modifier.fillMaxSize()
        ){
            Surface(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(50.dp),
                elevation = 5.dp,
                color = Color.White,
                shape = RoundedCornerShape(bottomStart = 15.dp, bottomEnd = 15.dp)
            ) {
                Row(
                    modifier = Modifier
                        .padding(horizontal = 30.dp, vertical = 10.dp),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ){
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
                            text = selectedHostel.value ?: "Hostel",
                            style = textStyle
                        )
                        Spacer(modifier = Modifier.width(10.dp))
                        Icon(
                            imageVector = Icons.Filled.ArrowDownward,
                            contentDescription = "Hostel",
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
                                    selectedHostel.value = "Kosi"
                                    expanded.value = false
                                }
                            ) {
                                Text(
                                    text = "Kosi",
                                    style = textStyle
                                )
                            }
                            DropdownMenuItem(
                                onClick = {
                                    selectedHostel.value = "Sone"
                                    expanded.value = false
                                }
                            ) {
                                Text(
                                    text = "Sone",
                                    style = textStyle
                                )
                            }
                            DropdownMenuItem(
                                onClick = {
                                    selectedHostel.value = "Brahmaputra"
                                    expanded.value = false
                                }
                            ) {
                                Text(
                                    text = "Brahmaputra",
                                    style = textStyle
                                )
                            }
                            DropdownMenuItem(onClick = {
                                selectedHostel.value = "Ganga"
                                expanded.value = false
                            }) {
                                Text(
                                    text = "Ganga",
                                    style = textStyle
                                )
                            }
                            DropdownMenuItem(onClick = {
                                selectedHostel.value = null
                                expanded.value = false
                            }) {
                                Text(
                                    text = "Clear",
                                    style = textStyle
                                )
                            }
                        }
                    }
                    Row(
                        modifier = Modifier
                            .border(
                                width = 1.dp,
                                color = Color(0xFFB7B7B7),
                                shape = RoundedCornerShape(corner = CornerSize(size = 12.dp))
                            )
                            .padding(all = 5.dp)
                            .clickable { mDatePickerDialog.show() },
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically
                    ){
                        Text(
                            text = selectedDate.value,
                            style = textStyle,
                        )
                        Spacer(modifier = Modifier.width(10.dp))
                        Icon(
                            imageVector = Icons.Filled.ArrowDownward,
                            contentDescription = "Select Date",
                            modifier = Modifier.size(size = 10.dp)
                        )

                    }
                }
            }
            Spacer(modifier = Modifier.height(20.dp))
            LazyColumn(
                modifier = Modifier.fillMaxSize()
            ){
                items(studentAlerts) {
                    studentAlert ->
                        AlertCards(studentAlert)
                }
            }
        }
    }
}

@Composable
private fun AlertCards(studentAlert: StudentAlert) {
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
                        painter = painterResource(id = studentAlert.dpUrl),
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
                            text = studentAlert.studentName,
                            style = TextStyle(
                                fontSize = 18.sp,
                                color = Color(0xFF565656),
                                fontWeight = FontWeight.W500
                            )
                        )
                        Text(
                            text = "Room no: ${studentAlert.roomNo}",
                            style = TextStyle(
                                fontSize = 12.sp,
                                color = Color(0xFF666666),
                                fontWeight = FontWeight.W400
                            )
                        )
                    }
                }
                Text(
                    text = studentAlert.date,
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
            Text(
                text = studentAlert.message,
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
                    text = studentAlert.time,
                    style = TextStyle(
                        fontSize = 16.sp,
                        fontWeight = FontWeight.W400,
                        color = Color(0xFF9F9F9F)
                    )
                )
            }
        }
    }
}