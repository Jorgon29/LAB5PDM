package com.example.jegctres.todolist

import androidx.compose.foundation.border
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun Card(title: String, description: String, remove: () -> Unit) {

    val done = rememberSaveable { mutableStateOf(false) }
    Row (
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .border(width = 10.dp, color = Color.Cyan)
            .fillMaxWidth()
            .horizontalScroll(rememberScrollState())
            .padding(5.dp)
    ) {
        Text(
            text = title,
            fontSize = 32.sp,
            fontWeight = FontWeight.Bold
        )

        Text(
            text = description,
            fontSize = 16.sp
        )
        Button(
            onClick = {done.value = !done.value}
        ) {
            Text(
                text = if (done.value) "Hecho" else "Pendiente"
            )
        }

        Button(
            onClick = {remove()}
        ) {
            Text(text = "Eliminar")
        }

    }
}