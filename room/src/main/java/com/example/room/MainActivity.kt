package com.example.room

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.room.Room
import com.example.room.database_room.AppDatabase
import com.example.room.database_room.Student
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val student: Student? = liveData.value

        liveData.observe(this, {
            student_name.text=student?.firstName
        })
        //val students: List<Student> = studentDao.getAllStudents()
    }
}