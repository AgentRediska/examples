package com.example.lifecycle

import android.content.Context
import android.nfc.Tag
import android.util.Log
import android.widget.Toast
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.OnLifecycleEvent

private const val TAG="serverTest"

 class ServerTest: LifecycleObserver {


        @OnLifecycleEvent(Lifecycle.Event.ON_START)
        fun connect() {
            Log.d(TAG, "Server is connected")
        }

        @OnLifecycleEvent(Lifecycle.Event.ON_STOP)
        fun disconnect() {
            Log.d(TAG, "Server is disconnected")
        }

 }