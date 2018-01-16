package com.abhay.kotlintutorial

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import android.R.menu
import android.view.Menu
import android.view.MenuItem


class OptionMenuActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_option_menu)
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.menu_mainxml, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.getItemId()) {
            R.id.item1 -> {
                Toast.makeText(this, "Item 1 is Selected", Toast.LENGTH_SHORT).show()
                return true
            }

            R.id.item2 -> {
                Toast.makeText(this, "Item 2 is Selected", Toast.LENGTH_SHORT).show()
                return true
            }

            R.id.item3 -> {
                Toast.makeText(this, "Item 3 is Selected", Toast.LENGTH_SHORT).show()
                return true
            }

            else -> return super.onOptionsItemSelected(item)
        }
    }
}
