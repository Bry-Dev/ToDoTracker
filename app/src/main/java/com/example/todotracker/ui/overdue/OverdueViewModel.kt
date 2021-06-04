package com.example.todotracker.ui.overdue

import androidx.lifecycle.*
import com.example.todotracker.model.ToDo
import com.example.todotracker.repository.ToDoRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class OverdueViewModel
@Inject constructor(private val toDoRepository: ToDoRepository) : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "This is dashboard Fragment"
    }
    val text: LiveData<String> = _text

    val allToDoOverdue : LiveData<List<ToDo>> = toDoRepository.allToDoOverdue.asLiveData()

    fun insertToDoOverdue(toDo: ToDo) = viewModelScope.launch { toDoRepository.insertToDoData(toDo) }

    fun updateToDoOverdue(toDo: ToDo) = viewModelScope.launch { toDoRepository.updateToDo(toDo) }
}