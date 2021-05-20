package com.example.todotracker.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.todotracker.model.ToDo

@Database(
    entities = [ToDo::class],
    version = 1,
    exportSchema = false
)
abstract class ToDoDatabase : RoomDatabase() {
}