package com.abhay.kotlintutorial

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import kotlinx.android.synthetic.main.activity_context_menu.*
import android.widget.Toast

import android.view.ContextMenu
import android.view.MenuItem
import android.view.View


class ContextMenuActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_context_menu)

        val planets = arrayOf("Mercury", "Venus", "Mars", "Earth", "Jupitor")
        val adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, planets)
        listView.setAdapter(adapter)
        registerForContextMenu(listView)
    }

    override fun onCreateContextMenu(menu: ContextMenu, v: View, menuInfo: ContextMenu.ContextMenuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo)
        menu.setHeaderTitle("Select the Action")
        menu.add(0, v.getId(), 0, "Delete")
        menu.add(0, v.getId(), 0, "UpperCase")
        menu.add(0, v.getId(), 0, "LowerCase")
    }

    override fun onContextItemSelected(item: MenuItem): Boolean {
        if (item.getTitle() === "Delete") {
            Toast.makeText(this, "Delete was pressed", Toast.LENGTH_SHORT).show()
        } else if (item.getTitle() === "UpperCase") {
            Toast.makeText(this, "UpperCase was pressed", Toast.LENGTH_SHORT).show()
        } else if (item.getTitle() === "LowerCase") {
            Toast.makeText(this, "LowerCase was pressed", Toast.LENGTH_SHORT).show()
        }
        return true
    }
}
