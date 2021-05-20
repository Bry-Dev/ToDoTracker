package com.example.todotracker.model

import android.os.Parcelable
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.Index
import androidx.room.PrimaryKey
import kotlinx.parcelize.Parcelize
import java.time.LocalDate

@Entity (tableName = "todo_list", indices = [Index(value = ["name"], unique = true)])
@Parcelize
data class ToDo (
    @ColumnInfo(name = "name")
    var name:String,
    @ColumnInfo(name = "status_date")
    var statusDate: LocalDate,
    @ColumnInfo(name = "status")
    var status: Int,
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "todo_id")
    val toDoId:Int = 0) : Parcelable {
}