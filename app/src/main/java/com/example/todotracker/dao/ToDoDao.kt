package com.example.todotracker.dao

import androidx.room.*
import com.example.todotracker.model.ToDo
import io.reactivex.rxjava3.core.Single
import kotlinx.coroutines.flow.Flow


@Dao
interface ToDoDao {

    @Insert(onConflict = OnConflictStrategy.ABORT)
    suspend fun insertToDoData(toDo: ToDo)

    @Query("select * from todo_list")
    fun selectAllTodo(): Flow<List<ToDo>>

    @Query("select name from todo_list where todo_id=:id")
    fun selectToDo(id: Int): Single<String>

    @Delete
    suspend fun deleteToDo(toDo: ToDo)

    @Query("delete from todo_list")
    suspend fun deleteAll()

    @Update
    suspend fun updateToDo(toDo: ToDo)
}