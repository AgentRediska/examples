package com.example.livedata

import androidx.lifecycle.LiveData

class MyLiveData:LiveData<String>() {

    //simulating changes
    fun setValueToLiveData(string: String){
        value= string
    }


    override fun onActive() {
        super.onActive()
        println("onActive")
        //connect to DB
    }

    override fun onInactive() {
        super.onInactive()
        println("onInactive")
        //disconnect to DB
    }
}