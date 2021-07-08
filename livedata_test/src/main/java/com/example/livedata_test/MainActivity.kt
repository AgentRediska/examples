package com.example.livedata_test

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer

    private lateinit var btn_set_text: Button
    private lateinit var text_test: TextView
    private lateinit var observer: Observer<String>

class MainActivity : AppCompatActivity() {

    private var ld=MyLDTest()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btn_set_text=findViewById(R.id.btn_set_text)
        btn_set_text.setOnClickListener {
            ld.setTextToText("text_example")
        }


        text_test=findViewById(R.id.text_test)

        observer= Observer<String> {
            text_test.text=it
        }

        ld.observe(this, observer)

    }
}