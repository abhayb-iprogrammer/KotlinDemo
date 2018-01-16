package com.abhay.kotlintutorial

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.content.Intent
import android.view.View


class ServiceLifeCycleAActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_service_life_cycle_a)

    }

    fun ServiceStart(v: View) {
        val i = Intent(this, ServiceLifeCycleSJava::class.java)
        startService(i)
    }

    //Method to Stop the Service
    fun ServiceStop(v: View) {
        val i = Intent(this, ServiceLifeCycleSJava::class.java)
        stopService(i)
    }
}
