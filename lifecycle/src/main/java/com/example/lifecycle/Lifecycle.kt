package com.example.lifecycle

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Lifecycle

class Lifecycle : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_livecycle)

        //This is good
        val serverTest= ServerTest()
        lifecycle.addObserver(serverTest)

        //check Event method or State
        if(lifecycle.currentState==Lifecycle.State.INITIALIZED){
            println("INITIALIZED")
            //TRUE
        }

        if(lifecycle.currentState==Lifecycle.State.CREATED){
            println("started")
            //FALSE
        }
    }


    //This is bad, because the code is very large
/*
    override fun onStart() {
        super.onStart()
        Server.connect(this)
    }

    override fun onStop() {
        super.onStop()
    Server.disconnect(this)
    }

*/
}