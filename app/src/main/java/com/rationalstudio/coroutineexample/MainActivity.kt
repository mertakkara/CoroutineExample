package com.rationalstudio.coroutineexample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.coroutines.*

class MainActivity : AppCompatActivity() {
    val TAG = "MyTag"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        Log.d(TAG,"Before runBlocking")
        runBlocking {
            launch(Dispatchers.IO) {
                delay(2000)
                Log.d(TAG,"Finished First Coroutine")
            }
            launch(Dispatchers.IO) {
                delay(2000)
                Log.d(TAG,"Finished Second Coroutine")
            }
            delay(5000)
            Log.d(TAG,"Finished runBlocking")

        }
        Log.d(TAG,"After runBlocking")

    }





}