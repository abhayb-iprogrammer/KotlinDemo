package com.abhay.kotlintutorial

import android.content.Intent
import android.os.Build
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.annotation.RequiresApi
import android.view.View
import android.widget.Toast

class ButtonActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_button)
    }

    fun btnClick(v: View) {
        Toast.makeText(this, "Button was Clicked", Toast.LENGTH_SHORT).show()
    }
}
