package com.abhay.kotlintutorial

import android.Manifest
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.content.Intent
import android.content.pm.PackageManager
import android.support.v4.app.ActivityCompat
import android.view.View
import android.widget.Toast


class ServiceExampleAActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_service_example_s)
    }

    fun ServiceStart(v: View) {

        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.READ_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED) {
            Toast.makeText(this, "Please grant the  permission", Toast.LENGTH_SHORT).show()
            requestPermission()
        } else {
            val i = Intent(this, ServiceExampleSJava::class.java)
            startService(i)
        }



    }

    //Method to Stop the Service
    fun ServiceStop(v: View) {
        val i = Intent(this, ServiceExampleSJava::class.java)
        stopService(i)
    }
    private fun requestPermission() {
        ActivityCompat.requestPermissions(this, arrayOf(Manifest.permission.READ_EXTERNAL_STORAGE), 1)
    }
}
