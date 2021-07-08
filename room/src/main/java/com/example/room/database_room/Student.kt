package com.example.room.database_room

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.*

@Entity(tableName = "students")
data class Student(
        @PrimaryKey val studentId: UUID = UUID.randomUUID(),
        @ColumnInfo (name = "first_name") var firstName: String="null",
        @ColumnInfo (name ="last_name") var lastName: String="null",
        @ColumnInfo (name= "group") var group: Int=0
)
