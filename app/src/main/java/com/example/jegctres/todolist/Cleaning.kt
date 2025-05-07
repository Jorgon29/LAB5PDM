package com.example.jegctres.todolist

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment

@Composable
fun CleaningRow(clean: () -> Unit, ){
    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceAround
    ) {
        Text(
            text = "Listado de tareas"
        )

        Button(
            onClick = {clean()}
        ) {
            Text( text = "Limpiar")
        }
    }
}