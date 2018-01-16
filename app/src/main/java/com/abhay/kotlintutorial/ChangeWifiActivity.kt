package com.abhay.kotlintutorial

import android.Manifest
import android.annotation.SuppressLint
import android.content.Context
import android.content.pm.PackageManager
import android.net.wifi.WifiManager
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.app.ActivityCompat
import android.view.View
import android.widget.Toast

class ChangeWifiActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_change_wifi)
        requestPermission()
    }

    @SuppressLint("WifiManagerLeak")
    fun btnON(v:View)
    {
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.CHANGE_WIFI_STATE) != PackageManager.PERMISSION_GRANTED) {
            Toast.makeText(this, "Please grant the  permission", Toast.LENGTH_SHORT).show()
            requestPermission()
        } else {
            val wifiMgr = getSystemService(Context.WIFI_SERVICE) as WifiManager
            wifiMgr.setWifiEnabled(true)
            Toast.makeText(getApplicationContext(), "Wifi is ON", Toast.LENGTH_SHORT).show();
        }
    }

    @SuppressLint("WifiManagerLeak")
    fun btnOFF(v:View)
    {
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.CHANGE_WIFI_STATE) != PackageManager.PERMISSION_GRANTED) {
            Toast.makeText(this, "Please grant the  permission", Toast.LENGTH_SHORT).show()
            requestPermission()
        } else {
            val wifiMgr = getSystemService(Context.WIFI_SERVICE) as WifiManager
            wifiMgr.setWifiEnabled(false)
            Toast.makeText(getApplicationContext(), "Wifi is ON", Toast.LENGTH_SHORT).show();
        }
    }
    private fun requestPermission() {
        ActivityCompat.requestPermissions(this, arrayOf(Manifest.permission.CHANGE_WIFI_STATE), 1)
    }
}
