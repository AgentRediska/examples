package com.example.room

import androidx.lifecycle.ViewModel
import com.example.room.database_room.Student
import com.example.room.database_room.StudentsRepository

class StudentsInfoViewModel: ViewModel(){

    private val studentsRepository = StudentsRepository.get()
    val studentsListLiveData = studentsRepository.getStudents()


}