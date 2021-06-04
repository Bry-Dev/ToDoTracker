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
    fun selectAllToDo(): Flow<List<ToDo>>

    @Query("select * from todo_list where status = 7")
    fun selectAllToDoCompleted(): Flow<List<ToDo>>

    @Query("select * from todo_list where status = 25")
    fun selectAllToDoInWork(): Flow<List<ToDo>>

    @Query("select * from todo_list where status = 31")
    fun selectAllToDoOverdue(): Flow<List<ToDo>>

    @Query("select name from todo_list where todo_id=:id")
    fun selectToDo(id: Int): Single<String>

    @Delete
    suspend fun deleteToDo(toDo: ToDo)

    @Query("delete from todo_list")
    suspend fun deleteAll()

    @Update
    suspend fun updateToDo(toDo: ToDo)
}