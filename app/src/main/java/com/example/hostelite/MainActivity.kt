package com.example.hostelite

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.hostelite.admin_screens.AdminAlertsScreen
import com.example.hostelite.admin_screens.AdminHome
import com.example.hostelite.admin_screens.ComplaintScreen
import com.example.hostelite.landing_pages.AdminCreateAccount
import com.example.hostelite.landing_pages.CreateAccountStudent
import com.example.hostelite.landing_pages.Login
import com.example.hostelite.student_screens.*
import com.example.hostelite.ui.theme.HosteliteTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            HosteliteTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    NavigationController()
                }
            }
        }
    }
}

@Composable
fun NavigationController(){
    val navController = rememberNavController()
    NavHost(navController = navController , startDestination = "homeadmin", builder = {
        composable("boarding") {
            BoardingPage(
                onNavigateToLogin = {
                    navController.navigate("login") {
                        popUpTo("boarding") {
                            inclusive = true
                        }
                    }
                }
            )
        }
        composable("login") {
            Login(
                onNavigateToStudentCreate = {navController.navigate("createStudentAccount") },
                onNavigateToAdminCreate = {navController.navigate("createAdminAccount")}
            )
        }
        composable("createStudentAccount") {
            CreateAccountStudent(
                onNavigateToLogin = {navController.navigate("login"){
                    launchSingleTop = true
                    popUpTo("createAccountStudent"){
                        inclusive = true
                    }
                }
                }
            )
        }
        composable("createAdminAccount") {
            AdminCreateAccount(
                onNavigateToLogin = {navController.navigate("login"){
                    launchSingleTop = true
                    popUpTo("createAccountStudent"){
                        inclusive = true
                    }
                }
                }
            )
        }
        composable(route = "homestudent") {
            StudentHome(navController)
        }

        composable(route = "homeadmin"){
            AdminHome(navController)
        }
        composable(route = "studententryexitreports"){

        }
        composable(route = "adminentryexitreports"){

        }
        composable(route = "mycomplaints"){
            MyComplaints(navController = navController)
        }
        composable(route = "studentprofile"){

        }
        composable(route = "adminprofile"){

        }
        composable(route = "adminalerts"){
            AdminAlertsScreen(navController = navController)
        }
        composable(route = "studentreportissue"){
            StudentReportIssue(navController = navController)
        }
        composable(route = "markentry"){
            MarkEntry(navController = navController)
        }
        composable(route = "markexit"){
            MarkExit(navController = navController)
        }
        composable(route = "studentalerts"){
            AlertsStudent(navController = navController)
        }
        composable(route = "admincomplaints"){
            ComplaintScreen(navController = navController)
        }
    })
}