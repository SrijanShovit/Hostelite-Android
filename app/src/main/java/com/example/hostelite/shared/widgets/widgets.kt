package com.example.hostelite.shared.widgets

import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.GraphicEq
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Timer
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.navigation.NavController
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.compose.currentBackStackEntryAsState

@Composable
fun BottomDrawer(navController: NavController){
    val items = listOf(
        BottomNavItem.Home,
        BottomNavItem.Reports,
        BottomNavItem.Complaints,
        BottomNavItem.Profile
    )
    BottomNavigation(
        backgroundColor = Color.White,
        contentColor = Color(0xFF8A8A8A)
    ) {
        val navBackStackEntry by navController.currentBackStackEntryAsState()
        val currentDestination = navBackStackEntry?.destination

        items.forEach{
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

sealed class BottomNavItem(val icon: ImageVector, val screen_route: String){
    object Home : BottomNavItem(icon = Icons.Filled.Home, screen_route = "homestudent")
    object Reports : BottomNavItem(icon = Icons.Filled.GraphicEq, screen_route = "entryexitreports")
    object Complaints : BottomNavItem(icon = Icons.Filled.Timer, screen_route = "mycomplaints")
    object Profile : BottomNavItem(icon = Icons.Filled.Person, screen_route = "profile")
}