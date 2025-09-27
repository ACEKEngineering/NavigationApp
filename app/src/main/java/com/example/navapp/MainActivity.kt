package com.example.navapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.navapp.ui.navigation.BottomNavigationBar
import com.example.navapp.ui.navigation.Screen
import com.example.navapp.ui.screens.BluetoothScreen
import com.example.navapp.ui.screens.BatteryScreen
import com.example.navapp.ui.screens.IntensityScreen
import com.example.navapp.ui.theme.NavAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            NavAppTheme {
                MainScreen()
            }
        }
    }
}

@Composable
fun MainScreen() {
    val navController = rememberNavController()
    
    Scaffold(
        modifier = Modifier.fillMaxSize(),
        bottomBar = {
            BottomNavigationBar(navController = navController)
        }
    ) { innerPadding ->
        NavHost(
            navController = navController,
            startDestination = Screen.Bluetooth.route,
            modifier = Modifier.padding(innerPadding)
        ) {
            composable(Screen.Bluetooth.route) {
                BluetoothScreen()
            }
            composable(Screen.Intensity.route) {
                IntensityScreen()
            }
            composable(Screen.Battery.route) {
                BatteryScreen()
            }
        }
    }
}