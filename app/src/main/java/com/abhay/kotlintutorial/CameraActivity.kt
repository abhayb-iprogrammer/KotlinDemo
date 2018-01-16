package com.abhay.kotlintutorial

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.provider.MediaStore
import android.view.View
import android.graphics.Bitmap
import android.app.Activity
import kotlinx.android.synthetic.main.activity_camera.*


class CameraActivity : AppCompatActivity() {

    val CAMERA_REQUEST = 123
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_camera)
    }

    fun btnClick(v:View){

        val i=Intent(MediaStore.ACTION_IMAGE_CAPTURE)
        startActivityForResult(i,CAMERA_REQUEST)
    }


    public override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent) {
        if (requestCode == CAMERA_REQUEST && resultCode == Activity.RESULT_OK)
        {
            val photo=data.extras!!.get("data")as Bitmap
            imageView.setImageBitmap(photo)

        }
    }


}
