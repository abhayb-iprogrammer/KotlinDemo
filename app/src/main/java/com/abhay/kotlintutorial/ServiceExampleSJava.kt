package com.abhay.kotlintutorial

import android.app.Service
import android.content.Intent
import android.os.IBinder
import android.widget.Toast
import android.R.attr.start
import android.R.raw
import android.media.MediaPlayer



class ServiceExampleSJava : Service() {
    var myPlayer: MediaPlayer? = null
    override fun onBind(intent: Intent): IBinder? {
        // TODO: Return the communication channel to the service.
        throw UnsupportedOperationException("Not yet implemented")
    }

    override fun onCreate() {
        super.onCreate()
        Toast.makeText(this, "onCreate in Service was Called", Toast.LENGTH_SHORT).show()
        myPlayer = MediaPlayer.create(this, R.raw.demosong)
    }

    override fun onStartCommand(intent: Intent, flags: Int, startId: Int): Int {
        myPlayer!!.start()
        return super.onStartCommand(intent, flags, startId)
    }

    override fun onDestroy() {
        super.onDestroy()
        myPlayer!!.stop()
        Toast.makeText(this, "onDestroy in Service was Called", Toast.LENGTH_SHORT).show()
    }
}
