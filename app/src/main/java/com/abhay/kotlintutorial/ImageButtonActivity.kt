package com.abhay.kotlintutorial

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast



class ImageButtonActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_image_button)
    }

    fun onImageClick(v: View) {
        Toast.makeText(this, "Image was Clicked", Toast.LENGTH_SHORT).show()
    }
}
