package com.abhay.kotlintutorial

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast



class SimpleToastActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_simple_toast)
    }

    fun btnClick(v: View) {
        //Displays Toast for 3.5 secs
        Toast.makeText(this, "This is a Toast Short Message", Toast.LENGTH_SHORT).show()
        //Displays Toast for 3.5 secs
        Toast.makeText(this, "This is a Toast Long Message", Toast.LENGTH_SHORT).show()
    }
}
