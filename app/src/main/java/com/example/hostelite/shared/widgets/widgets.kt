package com.example.hostelite.shared.widgets

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material.icons.outlined.ArrowBackIos
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.compose.currentBackStackEntryAsState

@Composable
fun UserDetailField(label: String, value: String){
    OutlinedTextField(
        value = value,
        onValueChange = {},
        label = {
            Text(
                text = label,
                style = TextStyle(
                    fontSize = 16.sp,
                    fontWeight = FontWeight.W400,
                    color = Color.Black
                )
            )
        },
        modifier = Modifier.fillMaxWidth().padding(vertical = 10.dp),
        enabled = false,
        textStyle = TextStyle(
            fontWeight = FontWeight.W400,
            fontSize = 17.sp,
            color = Color(0xFF5433FF)
        ),
        shape = RoundedCornerShape(corner = CornerSize(size = 15.dp))
    )

}
@Composable
fun AppBar(navController: NavController, text: String){
    TopAppBar(
        backgroundColor = Color(0xFFFE96FA),
        contentColor = Color.Black,
        modifier = Modifier.height(75.dp)
    ) {
        IconButton(onClick = {
            navController.popBackStack()
        }) {
            Icon(imageVector = Icons.Outlined.ArrowBackIos, contentDescription = null)
        }
        Text(
            text = text,
            style = TextStyle(
                fontSize = 24.sp,
                fontWeight = FontWeight.W500
            )
        )

    }
}
@Composable
fun BottomDrawer(navController: NavController, isStudent: Boolean){
    val studentItems = listOf(
        BottomNavItemStudent.Home,
        BottomNavItemStudent.Reports,
        BottomNavItemStudent.Complaints,
        BottomNavItemStudent.Profile
    )
    val adminItems = listOf(
        BottomNavItemAdmin.Home,
        BottomNavItemAdmin.Reports,
        BottomNavItemAdmin.Alerts,
        BottomNavItemAdmin.Profile
    )

    BottomNavigation(
        backgroundColor = Color.White,
        elevation = 30.dp,
        contentColor = Color(0xFF8A8A8A)
    ) {
        val navBackStackEntry by navController.currentBackStackEntryAsState()
        val currentDestination = navBackStackEntry?.destination

        if(isStudent){
            studentItems.forEach{
                    item ->
                BottomNavigationItem(
                    selected = currentDestination?.hierarchy?.any {it.route == item.screen_route} == true,
                    onClick = {
                        navController.navigate(item.screen_route){
                            popUpTo(navController.graph.findStartDestination().id){
                                saveState = true
                            }
                            launchSingleTop = true
                            restoreState = true
                        }
                    },
                    icon = { Icon(imageVector = item.icon, contentDescription = "")},
                    alwaysShowLabel = false,
                    selectedContentColor = Color(0xFFF989E7),
                    unselectedContentColor = Color(0xFF8A8A8A),
                )
            }
        }
        else{
            adminItems.forEach{
                    item ->
                BottomNavigationItem(
                    selected = currentDestination?.hierarchy?.any {it.route == item.screen_route} == true,
                    onClick = {
                        navController.navigate(item.screen_route){
                            popUpTo(navController.graph.findStartDestination().id){
                                saveState = true
                            }
                            launchSingleTop = true
                            restoreState = true
                        }
                    },
                    icon = { Icon(imageVector = item.icon, contentDescription = "")},
                    alwaysShowLabel = false,
                    selectedContentColor = Color(0xFFF989E7),
                    unselectedContentColor = Color(0xFF8A8A8A),
                )
            }
        }

    }

}

sealed class BottomNavItemStudent(val icon: ImageVector, val screen_route: String){
    object Home : BottomNavItemStudent(icon = Icons.Filled.Home, screen_route = "homestudent")
    object Reports : BottomNavItemStudent(icon = Icons.Filled.GraphicEq, screen_route = "studententryexitreports")
    object Complaints : BottomNavItemStudent(icon = Icons.Filled.Timer, screen_route = "mycomplaints")
    object Profile : BottomNavItemStudent(icon = Icons.Filled.Person, screen_route = "studentprofile")
}
sealed class BottomNavItemAdmin(val icon: ImageVector, val screen_route: String){
    object Home : BottomNavItemAdmin(icon = Icons.Filled.Home, screen_route = "homeadmin")
    object Reports : BottomNavItemAdmin(icon = Icons.Filled.GraphicEq, screen_route = "adminentryexitreports")
    object Alerts : BottomNavItemAdmin(icon = Icons.Filled.AddAlert, screen_route = "adminalerts")
    object Profile : BottomNavItemAdmin(icon = Icons.Filled.Person, screen_route = "adminprofile")

}