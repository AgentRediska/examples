package com.example.lifecycle

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class Lifecycle : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_livecycle)

        //This is good
        val serverTest= ServerTest()
        lifecycle.addObserver(serverTest)
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