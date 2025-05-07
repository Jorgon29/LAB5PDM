package com.example.jegctres.viewmodels

import androidx.lifecycle.ViewModel
import com.example.jegctres.model.Task
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow

class GeneralViewModel: ViewModel() {
    private val _tasks = MutableStateFlow<MutableList<Task>>(mutableListOf())
    val tasks = _tasks.asStateFlow()
    private val _ids = MutableStateFlow(0)

    fun addTask(task: Task) {
        _tasks.value = _tasks.value.toMutableList().apply { add(task) }
    }

    fun clear(){
        _tasks.value = _tasks.value.toMutableList().apply { clear() }
    }

    fun clearTask(task: Task){
        _tasks.value = _tasks.value.toMutableList().apply { remove(task) }
    }

    fun getId(): Int{
        return ++_ids.value
    }
}