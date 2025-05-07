package com.example.jegctres

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Scaffold
import com.example.jegctres.homescreen.HomeScreen
import com.example.jegctres.navigation.Layout
import com.example.jegctres.sensorscreen.SensorScreen
import com.example.jegctres.todolist.BaseContainer
import com.example.jegctres.ui.theme.JEGCTRESTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            JEGCTRESTheme {
                Layout()
            }
        }
    }
}