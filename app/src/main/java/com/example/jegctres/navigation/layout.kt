package com.example.jegctres.navigation

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.jegctres.screens.HomeScreenNavigation
import com.example.jegctres.screens.SensorScreenNavigation
import com.example.jegctres.screens.TodoListNavigation
import com.example.jegctres.homescreen.HomeScreen
import com.example.jegctres.sensorscreen.SensorScreen
import com.example.jegctres.todolist.BaseContainer
import com.example.jegctres.viewmodels.GeneralViewModel

@Composable
fun Layout(){

    val viewModel: GeneralViewModel = viewModel()
    val navController = rememberNavController()

    Scaffold(
    ) { innerPadding ->
        Column(
            modifier = Modifier.padding(innerPadding)
        ) {
            NavHost(
                startDestination = HomeScreenNavigation,
                navController = navController
            ) {

                composable<HomeScreenNavigation> {
                    HomeScreen(
                        todo = {navController.navigate(TodoListNavigation)},
                        sensor = {navController.navigate(SensorScreenNavigation)}
                    )
                }

                composable<TodoListNavigation> {
                    BaseContainer(viewModel)
                }

                composable<SensorScreenNavigation> {
                    SensorScreen()
                }
            }

        }
    }
}