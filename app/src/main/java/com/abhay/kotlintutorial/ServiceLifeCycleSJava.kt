package com.abhay.kotlintutorial

/**
 * Created by abhay on 9/1/18.
 */
import android.app.Service;
import android.content.Intent
import android.os.IBinder
import android.widget.Toast



class ServiceLifeCycleSJava : Service() {
    override fun onBind(p0: Intent?): IBinder {
        throw  UnsupportedOperationException("Not yet implemented");
    }


    override fun onCreate() {
        super.onCreate()
        Toast.makeText(this, "onCreate in Service was Called", Toast.LENGTH_SHORT).show()
    }

    override fun onStartCommand(intent: Intent, flags: Int, startId: Int): Int {
        Toast.makeText(this, "onStartCommand in Service was Called", Toast.LENGTH_SHORT).show()
        return super.onStartCommand(intent, flags, startId)
    }

    override fun onDestroy() {
        super.onDestroy()
        Toast.makeText(this, "onDestroy in Service was Called", Toast.LENGTH_SHORT).show()
    }

}