package com.abhay.kotlintutorial

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.content.Context.NOTIFICATION_SERVICE
import android.app.NotificationManager
import android.content.Context
import android.graphics.BitmapFactory
import android.graphics.Bitmap
import android.support.v4.app.NotificationCompat


class NotificationBigTextActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_notification_big_text)
    }

    fun btnClick_Notification(v: View){
        //To set large icon in notification
        val icon1 = BitmapFactory.decodeResource(resources,
                R.mipmap.ic_launcher)

        //Assign BigText style notification
        val bigText = NotificationCompat.BigTextStyle()
        bigText.bigText("Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged. It was popularised in the 1960s with the release of Letraset sheets containing Lorem Ipsum passages, and more recently with desktop publishing software like Aldus PageMaker including versions of Lorem Ipsum.")
        bigText.setBigContentTitle("Big Text Notification")
        bigText.setSummaryText("By: Author of Lorem ipsum")

        //build notification
        val mBuilder = NotificationCompat.Builder(this)
                .setSmallIcon(R.mipmap.ic_launcher)
                .setContentTitle("Big Text notification")
                .setContentText("This is test of big text style notification.")
                .setLargeIcon(icon1)
                .setStyle(bigText) as NotificationCompat.Builder

        // Gets an instance of the NotificationManager service
        val mNotificationManager = getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager

        //to post your notification to the notification bar
        mNotificationManager.notify(0, mBuilder.build())
    }
}
