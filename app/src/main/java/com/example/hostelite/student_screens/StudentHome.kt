package com.example.hostelite.student_screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.gestures.Orientation
import androidx.compose.foundation.gestures.ScrollableState
import androidx.compose.foundation.gestures.scrollable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AddAlert
import androidx.compose.material.icons.filled.Doorbell
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.outlined.AddAlert
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.hostelite.R
import com.example.hostelite.shared.widgets.BottomDrawer

@Composable
fun StudentHome(){
    Scaffold(
        modifier = Modifier.fillMaxSize(),
        bottomBar = { BottomDrawer() }
    ) {
        Box(modifier = Modifier.fillMaxSize()){
            Column(
                modifier = Modifier.align(Alignment.TopCenter)
            ) {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween
                ){
                    IconButton(onClick = { /*TODO*/ }) {
                        Icon(imageVector = Icons.Filled.Menu, contentDescription = "Menu")
                    }
                    Image(
                        painter = painterResource(id = R.drawable.hostellite ),
                        contentDescription = null
                    )
                    IconButton(onClick = { /*TODO*/ }) {
                        Icon(imageVector = Icons.Outlined.AddAlert, contentDescription = "Alert")
                    }
                }
                Spacer(modifier = Modifier.height(30.dp))
                Column(
                    modifier = Modifier
                        .padding(horizontal = 15.dp)
                        .scrollable(
                            state = rememberScrollState(),
                            orientation = Orientation.Vertical
                        )
                ) {
                    Text(
                        text = "27 September",
                        style = TextStyle(
                            fontSize = 16.sp,
                            color = Color(0xFFA7A7A7),
                            fontWeight = FontWeight.W600
                        )
                    )
                    Spacer(modifier = Modifier.height(10.dp))
                    Text(
                        text = "Hello, Ritwik",
                        style = TextStyle(
                            fontSize = 25.sp,
                            fontWeight = FontWeight.W700
                        )
                    )
                    Text(
                        text = "Let’s manage your Hostel Things",
                        style = TextStyle(
                            fontSize = 12.sp,
                            color = Color(0xFF858585),
                            fontWeight = FontWeight.W700
                        )
                    )
                    Spacer(modifier = Modifier.height(40.dp))
                    Text(
                        text = "Quick Access",
                        style = TextStyle(
                            fontSize = 25.sp,
                            fontWeight = FontWeight.W700
                        )
                    )
                    Spacer(modifier = Modifier.height(30.dp))

                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .fillMaxHeight(0.65f)
                    ){
                        Column(
                            modifier = Modifier
                                .weight(1f)
                                .clip(shape = RoundedCornerShape(corner = CornerSize(30.dp)))
                                .border(width = 2.dp, color = Color(0xAA000000))
                                .fillMaxHeight()
                                .padding(horizontal = 10.dp),
                            verticalArrangement = Arrangement.Center
                        ){
                            Image(
                                painter = painterResource(id = R.drawable.complaints),
                                contentDescription = "Post A Complaint",
                                modifier = Modifier.size(size = 150.dp)
                            )
                            Text(
                                text = "Post a",
                                style = TextStyle(
                                    fontSize = 14.sp,
                                    fontWeight = FontWeight.W400
                                ),
                                modifier = Modifier.padding(horizontal = 10.dp)
                            )
                            Text(
                                text = "Complaint",
                                style = TextStyle(
                                    fontSize = 20.sp,
                                    fontWeight = FontWeight.W700
                                ),
                                modifier = Modifier.padding(horizontal = 10.dp)
                            )
                        }
                        Spacer(modifier = Modifier.width(width = 7.dp))
                        Column(
                            modifier = Modifier.weight(1f)
                        ){
                            Row(
                                modifier = Modifier
                                    .clip(shape = RoundedCornerShape(corner = CornerSize(20.dp)))
                                    .background(Color(0xFFFFBCF4))
                                    .weight(1f),
                                verticalAlignment = Alignment.CenterVertically
                            ){
                                Image(
                                    painter = painterResource(id = R.drawable.entry),
                                    contentDescription = "Mark Entry",
                                    modifier = Modifier.size(100.dp)
                                )
                                Text(
                                    text = "Mark Entry",
                                    style = TextStyle(
                                        fontSize = 16.sp,
                                        fontWeight = FontWeight.W700,
                                        color = Color(0xFF7E1D7B)
                                    )
                                )
                            }
                            Spacer(modifier = Modifier.height(height= 7.dp))
                            Row(
                                modifier = Modifier
                                    .clip(shape = RoundedCornerShape(corner = CornerSize(20.dp)))
                                    .background(Color(0xFF51E71D))
                                    .weight(1f),
                                verticalAlignment = Alignment.CenterVertically
                            ){
                                Image(
                                    painter = painterResource(id = R.drawable.exit),
                                    contentDescription = "Mark Exit",
                                    modifier = Modifier.size(100.dp)
                                )
                                Text(
                                    text = "Mark Exit",
                                    style = TextStyle(
                                        fontSize = 16.sp,
                                        fontWeight = FontWeight.W700,
                                        color = Color.White
                                    )
                                )
                            }
                        }
                    }
                }
            }

        }
    }
}