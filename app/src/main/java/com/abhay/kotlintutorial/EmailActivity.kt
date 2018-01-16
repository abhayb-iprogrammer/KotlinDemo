package com.abhay.kotlintutorial

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.content.Intent
import android.net.Uri
import android.view.View


class EmailActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_email)
    }

    fun btnClick(v: View) {
        val i = Intent(Intent.ACTION_SEND)
        i.data = Uri.parse("email")
        val s = arrayOf("abc@gmail.com", "xyz@gmail.com")
        i.putExtra(Intent.EXTRA_EMAIL, s)
        i.putExtra(Intent.EXTRA_SUBJECT, "This is a Subject")
        i.putExtra(Intent.EXTRA_TEXT, "Hii This is the Email Body")
        i.type = "message/rfc822"
        val chooser = Intent.createChooser(i, "Launch Email")
        startActivity(chooser)
    }
}
