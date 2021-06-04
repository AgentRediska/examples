package com.example.livedata

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.KeyEvent
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {

    private lateinit var  testText1: TextView
    private lateinit var  testEditText2: EditText
    private lateinit var buttonSave: Button
    private lateinit var observer: Observer<String>

    //class instance created
    private var liveDateString= MutableLiveData<String>()

    //OR CREATE MINE LIVE DATA
    val myLiveData=MyLiveData()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

////////////////////////////////////////////////////////////////

        //1- set value for liveData in main thread
        liveDateString.value="Hello live data"

        //2- set value for liveData in background thread
        CoroutineScope(Dispatchers.IO).launch {
            liveDateString.postValue("Hello it's liveData in background")
        }

        testText1=findViewById(R.id.testText1)

        //set text from liveData
        testText1.text=liveDateString.value

////////////////////////////////////////////////////////////////
       observer= Observer {
            //if liveData has changes, executed this code
            testText1.text = it
        }

        //work with MINE LIVE DATA
        testEditText2=findViewById(R.id.testText2)
        myLiveData.observe(this,observer)

        buttonSave= findViewById(R.id.button_save)
        buttonSave.setOnClickListener{
            myLiveData.setValueToLiveData(testEditText2.text.toString())
        }

    }

    //observer will be used here
    override fun onStart() {
        super.onStart()
        myLiveData.observe(this,observer)
    }

    //observer will be removed
    override fun onStop() {
        super.onStop()
        myLiveData.removeObserver(observer)
    }

}