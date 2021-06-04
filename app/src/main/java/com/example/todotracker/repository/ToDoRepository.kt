package com.example.todotracker.repository

import androidx.annotation.WorkerThread
import com.example.todotracker.dao.ToDoDao
import com.example.todotracker.model.ToDo
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class ToDoRepository
@Inject
constructor(private var toDoDao: ToDoDao) {

    val allToDo : Flow<List<ToDo>> = toDoDao.selectAllToDo()

    val allToDoCompleted : Flow<List<ToDo>> = toDoDao.selectAllToDoCompleted()

    val allToDoInWork : Flow<List<ToDo>> = toDoDao.selectAllToDoInWork()

    val allToDoOverdue : Flow<List<ToDo>> = toDoDao.selectAllToDoOverdue()

    @WorkerThread
    suspend fun insertToDoData(toDo: ToDo) {
        toDoDao.insertToDoData(toDo)
    }

    @WorkerThread
    suspend fun updateToDo(toDo: ToDo) {
        toDoDao.updateToDo(toDo)
    }

    @WorkerThread
    suspend fun deleteToDo(toDo: ToDo) {
        toDoDao.deleteToDo(toDo)
    }

    @WorkerThread
    suspend fun deleteAll() {
        toDoDao.deleteAll()
    }

}