package com.example.room.database_room

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query

@Dao
interface StudentDAO {

    @Query("SELECT * FROM students")
    fun getAllStudents(): List<Student>

    @Query("SELECT * FROM students WHERE studentId == (:studId)")
    fun loadStudentsById(studId: Int): Student

    @Query("SELECT * FROM students WHERE first_name==(:studentsFirstName)")
    fun getStudentsByFirstName(studentsFirstName: String): List<Student>

    @Query("SELECT * FROM students WHERE `group` IN (:groups)")
    fun getStudentsByGroups(groups: List<Int>): List<Student>

    @Insert
    fun insertStudents(vararg student: Student)

    @Delete
    fun delete(student: Student)
}