package com.example.todotracker.database

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.todotracker.converter.DateConverters
import com.example.todotracker.dao.ToDoDao
import com.example.todotracker.model.ToDo

@Database(
    entities = [ToDo::class],
    version = 1,
    exportSchema = false
)
@TypeConverters(DateConverters::class)
abstract class ToDoDatabase : RoomDatabase() {

    abstract fun toDoDao() : ToDoDao
}