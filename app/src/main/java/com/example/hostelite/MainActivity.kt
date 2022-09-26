package com.example.hostelite

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.ui.Modifier
import com.example.hostelite.landing_pages.AdminCreateAccount
import com.example.hostelite.landing_pages.CreateAccountStudent
import com.example.hostelite.landing_pages.Login
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
                    AdminCreateAccount()
                }
            }
        }
    }
}