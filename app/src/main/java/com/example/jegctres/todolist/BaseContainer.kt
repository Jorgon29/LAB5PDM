package com.example.jegctres.todolist

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.sp
import androidx.lifecycle.ViewModel
import com.example.jegctres.model.Task
import com.example.jegctres.viewmodels.GeneralViewModel

@Composable
fun BaseContainer(viewModel: GeneralViewModel){
    val showModal = remember { mutableStateOf(false) }
    val tasks = viewModel.tasks.collectAsState()
    fun addEntry(title: String = "empty", description: String = "empty desc"){
        viewModel.addTask(
            Task(
                description = description,
                title = title,
                id = viewModel.getId()
            )
        )
        showModal.value = false
    }

    val title: MutableState<String> = remember { mutableStateOf("") }
    val description: MutableState<String> = remember { mutableStateOf("") }

    Scaffold { innerPadding ->

        Column(
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .padding(innerPadding)
        ) {
            if(showModal.value){
                InputBox(save = {addEntry(title.value, description.value)}, title = title, description = description)
            }
            CleaningRow(clean = {viewModel.clear()})

            FloatingActionButton(
                onClick = {showModal.value = true}
            ) {
                Text(
                    text = "+",
                    fontSize = 32.sp
                )
            }
            LazyColumn(
                modifier = Modifier
                    .border(width = 5.dp, color = Color.Red)
                    .fillMaxSize()
            ) {

                itemsIndexed(tasks.value.toList()) { index, item ->
                    Card(title = item.title, description = item.description, remove = {viewModel.clearTask(item)})
                }
            }
        }
    }


}