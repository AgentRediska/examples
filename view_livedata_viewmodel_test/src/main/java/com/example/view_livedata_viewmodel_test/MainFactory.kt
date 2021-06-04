package com.example.view_livedata_viewmodel_test

import android.app.Application
import android.widget.TextView
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

//factory for passing data from an activity to the ViewModel constructor
class MainFactory(private val application: Application, private val text: String):
    ViewModelProvider.AndroidViewModelFactory(application){
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return MainViewModel(application, text)as T
    }
}