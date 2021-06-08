package com.example.room.database_room

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [Student::class], version = 1)
abstract class AppDatabase: RoomDatabase() {
    abstract fun studentDao(): StudentDAO
}