package com.example.livedata_test

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.lifecycle.Observer

    private lateinit var btn_set_text: Button
    private lateinit var text_test: TextView
    private lateinit var observer:Observer<String>

class MainActivity : AppCompatActivity() {

    val liveData= LiveDataDB()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        observer= Observer {
            text_test.text= it
        }


        text_test=findViewById(R.id.text_test)
       liveData.observe(this, observer)

        btn_set_text= findViewById(R.id.btn_set_text)
        btn_set_text.setOnClickListener {
        liveData.setValueToLiveData("teee")
        }
    }
}