package com.example.room.database_room

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters

@Database(entities = [Student::class], version = 1, exportSchema = false)
@TypeConverters(StudentTypeConverters::class)
abstract class AppDatabase: RoomDatabase() {
    abstract fun studentDao(): StudentDAO
}