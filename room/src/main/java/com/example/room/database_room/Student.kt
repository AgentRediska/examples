package com.example.room.database_room

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "students")
data class Student(
    @PrimaryKey val studentId: Int,
    @ColumnInfo (name = "first_name") val firstName: String,
    @ColumnInfo (name ="last_name") val lastName: String,
    @ColumnInfo (name= "group") val group: Int
)
