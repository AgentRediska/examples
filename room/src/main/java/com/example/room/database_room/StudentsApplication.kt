package com.example.room.database_room

import android.app.Application

class StudentsApplication: Application() {

    override fun onCreate() {
        super.onCreate()
        StudentsRepository.initialize(this)
    }
}