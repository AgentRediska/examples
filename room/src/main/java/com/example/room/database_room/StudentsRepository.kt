package com.example.room.database_room

import android.content.Context
import androidx.lifecycle.LiveData

import androidx.room.Room
import java.util.concurrent.Executors

private const val DATABASE_NAME="database-university"

class StudentsRepository private constructor(context: Context){

    private val db: AppDatabase= Room.databaseBuilder(
        context.applicationContext,
        AppDatabase::class.java, DATABASE_NAME
    ).build()

    private val studentDao=db.studentDao()

    private val executor = Executors.newSingleThreadExecutor()

    fun getStudents(): LiveData<List<Student>> =studentDao.getAllStudents()

    fun getStudent(studId: Int): LiveData<Student?> = studentDao.getStudentById(studId)

    fun addStudent(student: Student) {
        executor.execute {
            studentDao.insertStudents(student)
        }

    }

    fun deleteStudent(student: Student) {
        executor.execute {
            studentDao.deleteStudent(student)
        }
    }

    fun addBothStudents(studentFirst: Student, studentSecond: Student) {
        executor.execute {
            studentDao.insertBothStudents(studentFirst, studentSecond)
        }
    }


    companion object{
        private var INSTANCE: StudentsRepository? = null

        fun initialize(context: Context){
            if(INSTANCE== null){
                INSTANCE= StudentsRepository(context)
            }
        }

        fun get(): StudentsRepository{
            return INSTANCE?:
            throw IllegalStateException("Student repository must be initialized")
        }
    }
}