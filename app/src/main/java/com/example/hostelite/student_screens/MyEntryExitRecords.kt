package com.example.hostelite.student_screens

import android.widget.Toast
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalClipboardManager
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.hostelite.shared.widgets.AppBar
import com.example.hostelite.shared.widgets.BottomDrawer

@Composable
fun MyEntryExitRecords(navController: NavController){
    val headers = listOf(
        "Date",
        "Exit Time",
        "Purpose",
        "Token",
        "Entry Time"
    )
    val data = listOf(
        listOf(
            "16-02-2022", "4:30 PM", "Market", "23456", "6:30 PM"
        ),
        listOf(
            "16-02-2022", "4:30 PM", "Market", "23456", "6:30 PM"
        ),
        listOf(
            "16-02-2022", "4:30 PM", "Market", "23456", "6:30 PM"
        ),
        listOf(
            "16-02-2022", "4:30 PM", "Market", "23456", "6:30 PM"
        ),
        listOf(
            "16-02-2022", "4:30 PM", "Market", "23456", "6:30 PM"
        ),
        listOf(
            "16-02-2022", "4:30 PM", "Market", "23456", "6:30 PM"
        ),
        listOf(
            "16-02-2022", "4:30 PM", "Market", "23456", "6:30 PM"
        ),
        listOf(
            "16-02-2022", "4:30 PM", "Market", "23456", "6:30 PM"
        ),
        listOf(
            "16-02-2022", "4:30 PM", "Market", "23456", "6:30 PM"
        ),
        listOf(
            "16-02-2022", "4:30 PM", "Market", "23456", "6:30 PM"
        ),
        listOf(
            "16-02-2022", "4:30 PM", "Market", "23456", "6:30 PM"
        ),
        listOf(
            "16-02-2022", "4:30 PM", "Market", "23456", "6:30 PM"
        ),
    )
    val context = LocalContext.current

    Scaffold(
        topBar = { AppBar(navController = navController, text = "Your Entry-Exit Reports")},
        bottomBar = { BottomDrawer(navController = navController, isStudent = true)}
    ) {
        val scrollStateHorizontal = rememberScrollState()
        val scrollStateVertical = rememberScrollState()
        val clipboardManager = LocalClipboardManager.current

            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(vertical = 20.dp)
                    .verticalScroll(scrollStateVertical)
                    .horizontalScroll(scrollStateHorizontal)
            ){
                val headerColor = Color(0xFF8D8D8D)
                val contentPrimaryColor = Color(0xFFC8F2FF)
                val contentSecondaryColor = Color(0xFF89E3FF)
                    Row(
                        modifier = Modifier
                            .background(color = headerColor)
                            .padding(all = 10.dp)
                    ){
                        headers.forEach {
                            header ->
                            Row(
                                modifier = Modifier.width(100.dp),
                                horizontalArrangement = Arrangement.Center,
                                verticalAlignment = Alignment.CenterVertically
                            ){
                                Text(
                                    text = header,
                                    style = TextStyle(
                                        fontSize = 16.sp,
                                        fontWeight = FontWeight.W500,
                                        color = Color.White
                                    )
                                )
                            }
                        }
                    }

                var isOdd = true
                data.forEach {
                    record ->
                        Row(
                            modifier = Modifier
                                .background(color = if(isOdd){
                                    contentPrimaryColor
                                }else{
                                    contentSecondaryColor
                                })
                                .padding(all = 10.dp)
                        ){
                            record.forEach {
                                value ->
                                Row(
                                    modifier = Modifier.width(100.dp),
                                    horizontalArrangement = Arrangement.Center,
                                    verticalAlignment = Alignment.CenterVertically
                                ){
                                    Text(
                                        text = value,
                                        style = TextStyle(
                                            fontSize = 12.sp,
                                            fontWeight = FontWeight.W500,
                                            color = Color.Black,
                                            textAlign = TextAlign.Center
                                        ),
                                        modifier = Modifier.clickable {
                                            clipboardManager.setText(AnnotatedString(value))
                                            Toast.makeText(context, "Copied to Clipboard", Toast.LENGTH_SHORT).show()
                                        }
                                    )
                                }

                            }
                        }
                    isOdd = !isOdd
                }
            }
    }
}

