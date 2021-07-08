package com.example.livedata_test

import androidx.lifecycle.MutableLiveData

class MyLDTest:MutableLiveData<String>() {
     fun setTextToText( text: String){
        value=text
    }
}