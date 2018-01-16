package com.abhay.kotlintutorial

import android.content.Context
import android.content.Intent
import android.net.Uri
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.ContextMenu
import android.view.View
import kotlinx.android.synthetic.main.activity_list_view.*
import android.widget.Toast
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.ListView
import java.util.*


class ListViewActivity : AppCompatActivity() {

    var charactersDC = arrayOf("Flash", "Arrow", "SuperGirl", "BatMan",
            "SuperMan", "Atom", "WonderWomen",
            "GreenLantern", "Aquaman", "Cyborg", "CaptainCold", "Darkseid",
            "FireStorm", "GreenArrow", "Grodd", "Joker", "KillerFrost",
            "Zoom", "ReverseFlash")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list_view)
        val adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, charactersDC)
        listView.setAdapter(adapter)
        //Setting onClickListener on ListView
        listView?.setOnItemClickListener { parent, view, position, id ->

            Toast.makeText(this, "item Clicked:"+" "+charactersDC[position],Toast.LENGTH_SHORT).show()
        }
    }
}

