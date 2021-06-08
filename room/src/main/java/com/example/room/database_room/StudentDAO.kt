package com.example.room.database_room

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query

@Dao
interface StudentDAO {

    @Query("SELECT * FROM students")
    fun getAllStudents(): LiveData<List<Student>>

    @Query("SELECT * FROM students WHERE studentId == (:studId)")
    fun getStudentById(studId: Int): LiveData<Student?>

    @Query("SELECT * FROM students WHERE first_name==(:studentsFirstName)")
    fun getStudentsByFirstName(studentsFirstName: String): LiveData<List<Student>>

    @Query("SELECT * FROM students WHERE `group` IN (:groups)")
    fun getStudentsByGroups(groups: List<Int>): LiveData<List<Student>>

    @Insert
    fun insertStudents(vararg student: Student)

    @Insert
    fun insertBothStudents( student1: Student, student2: Student)

    @Delete
    fun delete(student: Student)
}