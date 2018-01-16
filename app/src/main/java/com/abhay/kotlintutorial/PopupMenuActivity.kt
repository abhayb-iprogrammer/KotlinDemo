package com.abhay.kotlintutorial

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_popup_menu.*
import android.widget.Toast

import android.view.MenuItem
import android.view.View
import android.widget.PopupMenu


class PopupMenuActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_popup_menu)

    }

    fun onClick(view: View) {

        val popupMenu = PopupMenu(this, PopupMenu)
        popupMenu.getMenuInflater().inflate(R.menu.menu_mainxml, popupMenu.getMenu())
        popupMenu.setOnMenuItemClickListener(object : PopupMenu.OnMenuItemClickListener {
            override fun onMenuItemClick(item: MenuItem): Boolean {
                Toast.makeText(application, "Item Clicked: " + item.getTitle(), Toast.LENGTH_SHORT).show()
                return true
            }
        })
        popupMenu.show()
    }
}
