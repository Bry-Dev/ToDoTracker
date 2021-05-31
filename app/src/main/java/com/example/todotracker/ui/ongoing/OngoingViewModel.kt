package com.example.todotracker.ui.ongoing

import androidx.lifecycle.*
import com.example.todotracker.model.ToDo
import com.example.todotracker.repository.ToDoRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class OngoingViewModel
@Inject constructor(private val toDoRepository: ToDoRepository) : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "This is notifications Fragment"
    }
    val text: LiveData<String> = _text

    val allToDoInWork : LiveData<List<ToDo>> = toDoRepository.allToDoInWork.asLiveData()

    fun insertToDoInWork(toDo: ToDo) = viewModelScope.launch { toDoRepository.insertToDoData(toDo) }

    fun updateToDoInWork(toDo: ToDo) = viewModelScope.launch { toDoRepository.updateToDo(toDo) }
}