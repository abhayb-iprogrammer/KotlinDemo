package com.abhay.kotlintutorial

import android.Manifest
import android.annotation.SuppressLint
import android.content.Context
import android.content.pm.PackageManager
import android.net.wifi.WifiManager
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.text.format.Formatter.formatIpAddress
import android.net.wifi.WifiInfo
import android.support.v4.app.ActivityCompat
import android.text.format.Formatter
import android.widget.ArrayAdapter
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_read_contacts.*
import kotlinx.android.synthetic.main.activity_wifi.*

class WifiActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_wifi)
        requestPermission()

    }

    @SuppressLint("WifiManagerLeak", "MissingPermission")
    fun getWifiInformation(V: View)
    {

        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_WIFI_STATE) != PackageManager.PERMISSION_GRANTED) {
            Toast.makeText(this, "Please grant the  permission", Toast.LENGTH_SHORT).show()
            requestPermission()
        } else {
            val wifiMgr = getSystemService(Context.WIFI_SERVICE) as WifiManager
            val wifiInfo = wifiMgr.connectionInfo
            val ip = wifiInfo.ipAddress
            val macAddress = wifiInfo.macAddress
            val bssid = wifiInfo.bssid
            val rssi = wifiInfo.rssi
            val linkSpeed = wifiInfo.linkSpeed
            val ssid = wifiInfo.ssid
            val networkid = wifiInfo.networkId
            val ipAddress = Formatter.formatIpAddress(ip)
            val info = ("Ipaddress: " + ipAddress + "\n" + "MacAddress: " + macAddress + "\n" + "BSSID: " + bssid
                    + "\n" + "RSSI: " + rssi + "\n" + "LinkSpeed: " + linkSpeed + "\n" +
                    "SSID: " + ssid + "\n" + "NetworkId: " + networkid)
            Txtview.setText(info)
        }


    }

    private fun requestPermission() {
        ActivityCompat.requestPermissions(this, arrayOf(Manifest.permission.ACCESS_WIFI_STATE), 1)
    }
}
