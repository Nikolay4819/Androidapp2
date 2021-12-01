package com.example.myandroidapplication

import android.content.ContentValues.TAG
import android.util.Log



import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

const val TAG = "MainActivity"

class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        Log.d(TAG,"Ты видишь в зеркале своё изображенье?")
    }

    override fun onStart () {
        super.onStart()
        Log.d(TAG,"Скажи ему: Пора подобное создать;")
    }

    override fun onResume () {
        super.onResume()
        Log.d(TAG,"Иначе у земли ты совершишь хищенье,")
    }

    override fun onPause (){
        super.onPause()
        Log.d (TAG, "У юной матери отнимешь благодать.")
    }

    override fun onStop (){
         super.onStop()
         Log.d (TAG, "Где та красавица, чья девственная нива")
    }

    override fun onDestroy () {
          super.onDestroy()
          Log.d (TAG, "Такого пахаря отвергла бы, как ты?")
    }

}



<androidx.recyclerview.widget.RecyclerView

