package com.abhay.kotlintutorial

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.app.PendingIntent
import android.content.Intent
import android.content.Context.NOTIFICATION_SERVICE
import android.app.NotificationManager
import android.content.Context
import android.graphics.BitmapFactory
import android.support.v4.app.NotificationCompat
import android.view.View
import java.util.*


class NotificationBigPictureActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_notification_big_picture)
    }

    fun btnClick_Notification(v: View) {
        // Assign big picture notification
        val bigPictureStyle = NotificationCompat.BigPictureStyle()

        bigPictureStyle.bigPicture(
                BitmapFactory.decodeResource(resources,
                        R.mipmap.ic_launcher)).build()

        // Gets an instance of the NotificationManager service
        val notificationManager = getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager

        //set intents and pending intents to call activity on click of "show activity" action button of notification
        val resultIntent = Intent(this, MainActivity::class.java)
        resultIntent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
        val piResult = PendingIntent.getActivity(this,
                (Calendar.getInstance().getTimeInMillis() as Long).toInt(), resultIntent, 0)


        //build notification
        val builder = NotificationCompat.Builder(this)
                .setSmallIcon(R.mipmap.ic_launcher)
                .setContentTitle("Big picture notification")
                .setContentText("This is test of big picture notification.")
                .setStyle(bigPictureStyle)
                .addAction(R.mipmap.ic_launcher, "show activity", piResult)
                .addAction(R.mipmap.ic_launcher, "Share",
                        piResult) as NotificationCompat.Builder

        //to post your notification to the notification bar
        notificationManager.notify(0, builder.build())

    }
}
