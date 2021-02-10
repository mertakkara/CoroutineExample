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

        GlobalScope.launch(Dispatchers.IO) {
            val result = anotherFunction()
            Log.d(TAG,"This thread is ${Thread.currentThread().name}")
            withContext(Dispatchers.Main){
                Log.d(TAG,"This thread is ${Thread.currentThread().name}")
                mytx.text = result
            }
        }
    }

    suspend fun anotherFunction():String{
        delay(3000)
        return "Result"
    }



}