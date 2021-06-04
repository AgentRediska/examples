package com.example.livedata

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import androidx.lifecycle.Transformations

class TransformationLiveData : AppCompatActivity() {

    var ldString = MutableLiveData<String>()
    var ldInt = MutableLiveData<Int>()

    lateinit var textViewInt: TextView
    lateinit var textViewString: TextView
    lateinit var button: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_transformation_live_data)

        ldString.value= "ldString"
        ldInt.value= 1

        textViewString=findViewById(R.id.textViewT)
        textViewInt=findViewById(R.id.textViewT2)

        textViewString.text= ldString.value
        textViewInt.text=ldInt.value.toString()

        button=findViewById(R.id.buttonT)
        button.setOnClickListener{
            ldString=Transformations.map(ldInt){
                it.toString()
            }as MutableLiveData<String>

            ldString.observe(this, Observer {
                textViewString.text=it
            })
        }
    }
}