package com.example.room

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.room.Room
import com.example.room.database_room.AppDatabase
import com.example.room.database_room.Student

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val db= Room.databaseBuilder(
            applicationContext,
            AppDatabase::class.java,"database-university"
        ).build()

        val studentDao=db.studentDao()
        val students: List<Student> = studentDao.getAllStudents()
    }
}