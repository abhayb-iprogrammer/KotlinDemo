package com.abhay.kotlintutorial

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import android.content.Intent



class WhatsAppActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_whats_app)
    }

    fun btnClick(v:View){
        try {
            val sharingIntent = Intent(Intent.ACTION_SEND)
            sharingIntent.type = "text/plain"
            sharingIntent.putExtra(Intent.EXTRA_TEXT, "This is Nice App for Learning Android" + "\n" + "https://play.google.com/store/apps/details?id=com.abhay.androidtutorial&hl=en")
            sharingIntent.`package` = "com.whatsapp"
            startActivity(sharingIntent)
        } catch (e: Exception) {
            Toast.makeText(applicationContext, "Please Install the WhatsApp App", Toast.LENGTH_SHORT).show()
        }

    }
}
