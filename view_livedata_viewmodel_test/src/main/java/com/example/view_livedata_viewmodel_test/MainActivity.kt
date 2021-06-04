package com.example.view_livedata_viewmodel_test

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import android.widget.TextView
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider

private lateinit var textView: TextView

class MainActivity : AppCompatActivity() {

    lateinit var myViewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        textView=findViewById(R.id.timer_text)

        myViewModel= ViewModelProvider(this,MainFactory(application, "Factory"))
            .get(MainViewModel::class.java)
    }

    override fun onStart() {
        super.onStart()
        myViewModel.liveData.observe(this, Observer {
            textView.text=it
        })
    }


}