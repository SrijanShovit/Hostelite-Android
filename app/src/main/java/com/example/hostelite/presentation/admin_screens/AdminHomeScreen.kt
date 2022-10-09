package com.example.hostelite.presentation.admin_screens

import androidx.compose.foundation.*
import androidx.compose.foundation.gestures.Orientation
import androidx.compose.foundation.gestures.scrollable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material.icons.outlined.Close
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.hostelite.R
import com.example.hostelite.shared.widgets.BottomDrawer
import kotlinx.coroutines.launch

@Composable
fun AdminHome(navController: NavController){
    val drawerState = rememberDrawerState(initialValue = DrawerValue.Closed)
    val coroutineScope = rememberCoroutineScope()
    ModalDrawer(
        drawerContent = {
            Box(
                modifier = Modifier.fillMaxSize()
            ){
                IconButton(onClick = {
                    coroutineScope.launch { drawerState.close() }
                },
                    modifier = Modifier
                        .align(Alignment.TopEnd)
                        .padding(top = 20.dp)) {
                    Icon(
                        imageVector = Icons.Outlined.Close,
                        contentDescription = null,
                    )
                }
                Text(
                    text = "App Version 1.0",
                    modifier = Modifier
                        .align(Alignment.BottomCenter)
                        .padding(bottom = 15.dp),
                    style = TextStyle(
                        fontSize = 14.sp,
                        fontWeight = FontWeight.W400,
                        color = Color(0xFF544D4D)
                    )
                )
                Column(
                    modifier = Modifier
                        .align(Alignment.Center),
                    horizontalAlignment = Alignment.CenterHorizontally
                ){
                    Image(
                        painter = painterResource(id = R.drawable.ritwik),
                        contentDescription = "dp",
                        modifier = Modifier
                            .size(140.dp)
                            .clip(CircleShape)
                    )
                    Spacer(modifier = Modifier.height(20.dp))
                    Text(
                        text = "Ritwik Singh",
                        style = TextStyle(
                            color = Color(0xFF636363),
                            fontSize = 28.sp,
                            fontWeight = FontWeight.W700
                        )
                    )
                    Spacer(modifier = Modifier.height(5.dp))
                    Text(
                        text = "Hostel Incharge",
                        style = TextStyle(
                            fontSize = 20.sp,
                            color = Color(0xFF535353),
                            fontWeight = FontWeight.W400
                        )
                    )
                    Spacer(modifier = Modifier.height(15.dp))
                    Divider(
                        modifier = Modifier.fillMaxWidth(0.70f),
                        thickness = 1.dp,
                        color = Color.Black
                    )
                    Spacer(modifier = Modifier.height(45.dp))
                    Column(){
                        drawerContent(text = "Edit Profile", icon = Icons.Filled.Edit)
                        Spacer(modifier = Modifier.height(25.dp))
                        drawerContent(text = "Notifications", icon = Icons.Filled.Notifications)
                        Spacer(modifier = Modifier.height(25.dp))
                        drawerContent(text = "Report Bug", icon = Icons.Filled.Dangerous)
                        Spacer(modifier = Modifier.height(25.dp))
                        drawerContent(text = "App Updates", icon = Icons.Filled.Download)
                        Spacer(modifier = Modifier.height(25.dp))
                        drawerContent(text = "Contact Us", icon = Icons.Filled.Contacts)
                        Spacer(modifier = Modifier.height(25.dp))
                        drawerContent(text = "Log Out", icon = Icons.Filled.Logout)
                        Spacer(modifier = Modifier.height(25.dp))
                    }
                }
            }
        },
        drawerState = drawerState,
        modifier = Modifier
            .fillMaxHeight()
            .fillMaxWidth(),
        gesturesEnabled = true,
        drawerBackgroundColor = Color(0xFFFFBCF4),
        drawerContentColor = Color(0xFF641F65),
        content = { Scaffold(
            modifier = Modifier.fillMaxSize(),
            bottomBar = { BottomDrawer(navController, false) }
        ) {
            Box(modifier = Modifier.fillMaxSize()){
                Column(
                    modifier = Modifier.align(Alignment.TopCenter)
                ) {
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween
                    ){
                        IconButton(onClick = {
                            coroutineScope.launch {
                                drawerState.open()
                            }
                        },
                        modifier = Modifier.weight(0.5f)) {
                            Icon(imageVector = Icons.Filled.Menu, contentDescription = "Menu")
                        }
                        Image(
                            painter = painterResource(id = R.drawable.hostellite ),
                            contentDescription = null,
                            modifier = Modifier.weight(4f)
                        )
                        Spacer(modifier = Modifier.weight(0.5f))
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

                        Column(
                            modifier = Modifier.fillMaxSize()
                        ){
                            Row(
                                verticalAlignment = Alignment.CenterVertically,
                                modifier = Modifier
                                    .clip(shape = RoundedCornerShape(corner = CornerSize(30.dp)))
                                    .clickable { navController.navigate(route = "admincomplaints") }
                                    .border(width = 2.dp, color = Color(0xAA000000))
                                    .fillMaxWidth()
                                    .fillMaxHeight(0.40f)
                                    .padding(horizontal = 10.dp),
                            ){
                                Image(
                                    painter = painterResource(id = R.drawable.complaints),
                                    contentDescription = "Post A Complaint",
                                    modifier = Modifier.size(size = 150.dp)
                                )
                                Column(){
                                    Text(
                                        text = "View",
                                        style = TextStyle(
                                            fontSize = 14.sp,
                                            fontWeight = FontWeight.W400
                                        ),
                                        modifier = Modifier.padding(horizontal = 10.dp)
                                    )
                                    Text(
                                        text = "Complaints",
                                        style = TextStyle(
                                            fontSize = 20.sp,
                                            fontWeight = FontWeight.W700
                                        ),
                                        modifier = Modifier.padding(horizontal = 10.dp)
                                    )
                                }
                            }
                            Spacer(modifier = Modifier.fillMaxHeight(0.1f))
                            Row(
                                verticalAlignment = Alignment.CenterVertically,
                                modifier = Modifier
                                    .clip(shape = RoundedCornerShape(corner = CornerSize(30.dp)))
                                    .fillMaxWidth()
                                    .fillMaxHeight(0.5f)
                                    .background(Color(0xFFFFBCF4))
                                    .padding(horizontal = 10.dp),
                            ){
                                Image(
                                    painter = painterResource(id = R.drawable.entry),
                                    contentDescription = "Entry/Exit Reports",
                                    modifier = Modifier.size(size = 150.dp)
                                )
                                Column(){
                                    Text(
                                        text = "Entry/Exit",
                                        style = TextStyle(
                                            fontSize = 14.sp,
                                            fontWeight = FontWeight.W500,
                                            color = Color(0xFF743C7D)
                                        ),
                                        modifier = Modifier.padding(horizontal = 10.dp)
                                    )
                                    Text(
                                        text = "Reports",
                                        style = TextStyle(
                                            fontSize = 20.sp,
                                            fontWeight = FontWeight.W700
                                        ),
                                        modifier = Modifier.padding(horizontal = 10.dp)
                                    )
                                }
                            }
                        }
                    }
                }
            }
        }
        }
    )
}

@Composable
fun drawerContent(text: String, icon: ImageVector){
    Row(
        modifier = Modifier
            .padding(horizontal = 30.dp)
            .fillMaxWidth(),
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically
    ){
        Icon(
            imageVector = icon,
            contentDescription = "Edit Profile",
            modifier = Modifier.size(20.dp)
        )
        Spacer(modifier = Modifier.width(10.dp))
        Text(
            text = text,
            style = TextStyle(
                fontSize = 18.sp,
                fontWeight = FontWeight.W500,
                color = Color(0xFF641F65)
            )
        )
    }

}