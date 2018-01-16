package com.abhay.kotlintutorial.categories

import android.os.Bundle
import android.support.design.widget.BottomNavigationView
import android.support.design.widget.Snackbar
import android.support.design.widget.NavigationView
import android.support.v4.view.GravityCompat
import android.support.v7.app.ActionBarDrawerToggle
import android.support.v7.app.AppCompatActivity
import android.view.Menu
import android.view.MenuItem
import com.abhay.kotlintutorial.R

import kotlinx.android.synthetic.main.activity_home_drawer2.*
import kotlinx.android.synthetic.main.app_bar_home_drawer.*
import kotlinx.android.synthetic.main.content_home_drawer.*

class HomeDrawerActivity : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home_drawer2)
        setSupportActionBar(toolbar)

        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener)

        fab.setOnClickListener { view ->
            Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                    .setAction("Action", null).show()
        }

        val toggle = ActionBarDrawerToggle(
                this, drawer_layout, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close)
        drawer_layout.addDrawerListener(toggle)
        toggle.syncState()

        nav_view.setNavigationItemSelectedListener(this)
    }

    override fun onBackPressed() {
        if (drawer_layout.isDrawerOpen(GravityCompat.START)) {
            drawer_layout.closeDrawer(GravityCompat.START)
        } else {
            super.onBackPressed()
        }
    }

    private val mOnNavigationItemSelectedListener = BottomNavigationView.OnNavigationItemSelectedListener { item ->
        when (item.itemId) {
            R.id.navigation_tutorial -> {
                message.setText(R.string.title_tutorial)
                return@OnNavigationItemSelectedListener true
            }
            R.id.navigation_example-> {
                message.setText(R.string.title_example)
                return@OnNavigationItemSelectedListener true
            }
            R.id.navigation_color -> {
                message.setText(R.string.title_color)
                return@OnNavigationItemSelectedListener true
            }

            R.id.navigation_opensource-> {
                message.setText(R.string.title_opensource)
                return@OnNavigationItemSelectedListener true
            }

        }
        false
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        // Handle navigation view item clicks here.
        when (item.itemId) {
//            R.id.nav_camera -> {
//                // Handle the camera action
//            }
//            R.id.nav_gallery -> {
//
//            }
//            R.id.nav_slideshow -> {
//
//            }
//            R.id.nav_manage -> {
//
//            }
//            R.id.nav_share -> {
//
//            }
//            R.id.nav_send -> {
//
//            }
        }

        drawer_layout.closeDrawer(GravityCompat.START)
        return true
    }
}
