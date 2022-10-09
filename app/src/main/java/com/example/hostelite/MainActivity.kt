package com.example.hostelite

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.hostelite.presentation.Authentication.AuthenticationViewModel
import com.example.hostelite.presentation.admin_screens.*
import com.example.hostelite.presentation.landing_pages.AdminCreateAccount
import com.example.hostelite.presentation.landing_pages.CreateAccountStudent
import com.example.hostelite.presentation.landing_pages.Login
import com.example.hostelite.presentation.landing_pages.SplashScreen
import com.example.hostelite.presentation.student_screens.*
import com.example.hostelite.ui.theme.HosteliteTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
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
                    val navController = rememberNavController()
                    val authViewModel : AuthenticationViewModel = hiltViewModel()
                    NavigationController(navController, authViewModel)
                }
            }
        }
    }
}

@Composable
fun NavigationController(navController: NavHostController, authViewModel: AuthenticationViewModel){
    NavHost(navController = navController, startDestination = "splashscreen", builder = {
        composable("splashscreen"){
            SplashScreen(navController = navController, authViewModel = authViewModel)
        }
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
                navController = navController,
                viewModel = authViewModel
            )
        }
        composable("createStudentAccount") {
            CreateAccountStudent(navController = navController, viewModel = authViewModel)
        }
        composable("createAdminAccount") {
            AdminCreateAccount(navController = navController, viewModel = authViewModel)
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
            StudentProfile(navController = navController, viewModel = authViewModel)
        }
        composable(route = "adminprofile"){
            AdminProfile(navController = navController)
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
        composable(route = "editstudentprofile"){
            EditStudentProfile(navController = navController)
        }
        composable(route = "editadminprofile"){
            EditAdminProfile(navController = navController)
        }
    })
}