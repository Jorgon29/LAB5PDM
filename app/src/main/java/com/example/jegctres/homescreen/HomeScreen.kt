package com.example.jegctres.homescreen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.jegctres.viewmodels.GeneralViewModel

@Composable
fun HomeScreen(sensor: ()-> Unit, todo: ()->Unit){


        Column(
            modifier = Modifier
                .padding(16.dp)
                .fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {

            Button(
                onClick = {
                    todo()
                }
            ) {
                Text(
                    text = "TODO"
                )
            }
            Spacer(
                modifier = Modifier
                    .height(24.dp)
            )
            Button(
                onClick = {
                    sensor()
                }
            ) {
                Text(
                    text = "Sensor"
                )
            }


        }
}