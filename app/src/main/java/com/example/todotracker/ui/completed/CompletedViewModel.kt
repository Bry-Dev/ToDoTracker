package com.example.todotracker.ui.completed

import androidx.lifecycle.*
import com.example.todotracker.model.ToDo
import com.example.todotracker.repository.ToDoRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CompletedViewModel
@Inject constructor(private val toDoRepository: ToDoRepository) : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "This is home Fragment"
    }
    val text: LiveData<String> = _text

    val allToDoCompleted : LiveData<List<ToDo>> = toDoRepository.allToDoCompleted.asLiveData()

    fun insertToDoCompleted(toDo: ToDo) = viewModelScope.launch { toDoRepository.insertToDoData(toDo) }

    fun updateToDoCompleted(toDo: ToDo) = viewModelScope.launch { toDoRepository.updateToDo(toDo) }
}