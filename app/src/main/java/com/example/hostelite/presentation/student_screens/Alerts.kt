package com.example.hostelite.presentation.student_screens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.hostelite.shared.widgets.AppBar

data class StudentAlert(
    val date: String,
    val message: String,
    val time: String
)

@Composable
fun AlertsStudent(navController: NavController){
    val alerts : MutableList<StudentAlert> = mutableListOf(
        StudentAlert(
            date = "18-05-2022",
            message = "Its 08:30 PM already and you have not marked your entry yet in the hostel. If it is for necessary work then state the reason otherwise necessary actions would be taken.",
            time = "8:30 pm"
        ),
        StudentAlert(
            date = "14-05-2022",
            message = "Its 08:30 PM already and you have not marked your entry yet in the hostel. If it is for necessary work then state the reason otherwise necessary actions would be taken.",
            time = "8:30 pm"
        ),
        StudentAlert(
            date = "30-04-2022",
            message = "Its 08:30 PM already and you have not marked your entry yet in the hostel. If it is for necessary work then state the reason otherwise necessary actions would be taken.",
            time = "8:30 pm"
        ),
        StudentAlert(
            date = "18-04-2022",
            message = "Its 08:30 PM already and you have not marked your entry yet in the hostel. If it is for necessary work then state the reason otherwise necessary actions would be taken.",
            time = "8:30 pm"
        ),
        StudentAlert(
            date = "18-03-2022",
            message = "Its 08:30 PM already and you have not marked your entry yet in the hostel. If it is for necessary work then state the reason otherwise necessary actions would be taken.",
            time = "8:30 pm"
        ),
    )
    Scaffold(
        topBar = { AppBar(navController = navController, text = "Alerts")}
    ) {
        LazyColumn(
            modifier = Modifier.fillMaxSize(),
            contentPadding = PaddingValues(vertical = 20.dp)
        ){
            items(alerts) {
                alert ->
                    Alert(alert)
            }
        }
    }
}

@Composable
fun Alert(studentAlert: StudentAlert) {
    Column(
        modifier = Modifier
            .padding(horizontal = 20.dp, vertical = 20.dp)
            .fillMaxWidth()
    ){
        Text(
            text = studentAlert.date,
            style = TextStyle(
                fontSize = 18.sp,
                fontWeight = FontWeight.W400,
            ),
            modifier = Modifier.padding(horizontal = 3.dp)
        )
        Card(
            shape = RoundedCornerShape(corner = CornerSize(size = 25.dp)),
            backgroundColor = Color(0xFFEFEFEF),
            modifier = Modifier.fillMaxWidth()
        ) {
            Column(
                modifier = Modifier.padding(all = 10.dp)
            ){
                Text(
                    text = studentAlert.message,
                    style = TextStyle(
                        color = Color(0xFF372F2F),
                        fontSize = 16.sp,
                        fontWeight = FontWeight.W400
                    )
                )
                Row(
                    horizontalArrangement = Arrangement.SpaceBetween,
                    modifier = Modifier.fillMaxWidth()
                ){
                    Spacer(modifier = Modifier.width(10.dp))
                    Text(
                        text = studentAlert.time,
                        style = TextStyle(
                            fontSize = 14.sp,
                            color = Color(0xFF686868),
                            fontWeight = FontWeight.W400
                        )
                    )
                }
            }
        }
    }
}
