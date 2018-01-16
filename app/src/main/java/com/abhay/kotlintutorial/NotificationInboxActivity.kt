package com.abhay.kotlintutorial

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.content.Context.NOTIFICATION_SERVICE
import android.app.NotificationManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.support.v4.app.NotificationCompat
import android.view.View


import java.util.*
import kotlinx.android.synthetic.main.activity_notification_inbox.*

class NotificationInboxActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_notification_inbox)

    }

    fun btnClick_Notification(v: View){
        //set intents and pending intents to call activity on click of "show activity" action button of notification
        val resultIntent = Intent(this, MainActivity::class.java)
        resultIntent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
        val piResult = PendingIntent.getActivity(this,
                (Calendar.getInstance().getTimeInMillis() as Long).toInt(), resultIntent, 0)

        //Assign inbox style notification
        val inboxStyle = NotificationCompat.InboxStyle()

        inboxStyle.setBigContentTitle("Inbox Notification")
        inboxStyle.addLine("Message 1.")
        inboxStyle.addLine("Message 2.")
        inboxStyle.addLine("Message 3.")
        inboxStyle.addLine("Message 4.")
        inboxStyle.addLine("Message 5.")
        inboxStyle.setSummaryText("+2 more")

        //build notification
        val mBuilder = NotificationCompat.Builder(this)
                .setSmallIcon(R.mipmap.ic_launcher)
                .setContentTitle("Inbox style notification")
                .setContentText("This is test of inbox style notification.")
                .setStyle(inboxStyle)
                .addAction(R.mipmap.ic_launcher, "show activity", piResult) as NotificationCompat.Builder

        // Gets an instance of the NotificationManager service
        val notificationManager = getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager

        //to post your notification to the notification bar
        notificationManager.notify(0, mBuilder.build())
    }
}
