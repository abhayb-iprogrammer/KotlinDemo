package com.abhay.kotlintutorial

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.content.Context.NOTIFICATION_SERVICE
import android.app.NotificationManager
import android.content.Context
import android.support.v7.app.NotificationCompat


class NotificationActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_notification)
    }

    fun btnClick(v:View)
    {
        //build notification
        val mBuilder = NotificationCompat.Builder(this)
                .setSmallIcon(R.mipmap.ic_launcher)
                .setContentTitle("Simple notification")
                .setContentText("This is test of simple notification.") as NotificationCompat.Builder
// Gets an instance of the NotificationManager service
        val notificationManager = getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager

//to post your notification to the notification bar
        notificationManager.notify(0, mBuilder.build())
    }
}
