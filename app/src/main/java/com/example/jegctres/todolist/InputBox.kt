package com.example.jegctres.todolist

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog


@Composable
fun InputBox(save: () -> Unit, title: MutableState<String>, description: MutableState<String> ) {
    Dialog(
        onDismissRequest = {}
    ) {
        Column(
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .padding(24.dp)
        ) {
            TextField(
                value = title.value,
                onValueChange = {
                    title.value = it
                },
                placeholder = { Text( text = "Tarea")}
            )

            TextField(
                value = description.value,
                onValueChange = {
                    description.value = it
                },
                placeholder = { Text( text = "Descripcion")}
            )

            Button(
                onClick = {
                    save()
                    title.value = ""
                    description.value = ""
                },
            ) {
                Text(
                    text = "Guardar"
                )
            }
        }
    }

}