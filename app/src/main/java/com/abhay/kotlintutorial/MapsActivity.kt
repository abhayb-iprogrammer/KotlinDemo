package com.abhay.kotlintutorial

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.content.Intent
import android.net.Uri
import android.view.View


class MapsActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_maps)
    }

    fun btnClick(v: View) {
        val i = Intent(Intent.ACTION_VIEW)
        i.data = Uri.parse("geo:18.516726,73.856255")
        val chooser = Intent.createChooser(i, "Launch Maps")
        startActivity(chooser)
    }
}
