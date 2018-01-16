package com.abhay.kotlintutorial

import android.Manifest
import android.annotation.SuppressLint
import android.content.Context
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import android.hardware.usb.UsbDevice.getDeviceId
import android.telephony.TelephonyManager
import android.content.Context.TELEPHONY_SERVICE
import android.content.Intent
import android.content.pm.PackageManager
import android.support.v4.app.ActivityCompat
import android.support.v4.content.ContextCompat
import android.view.View
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_telephony_manager.*


class TelephonyManagerActivity : AppCompatActivity() {
    var info: String? = null
    var strphoneType = ""
    private val MY_PERMISSIONS_REQUEST = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_telephony_manager)
    }

    fun Start(v:View)
    {

        val permissionCheck = ContextCompat.checkSelfPermission(this, Manifest.permission.READ_PHONE_STATE)

        if (permissionCheck == PackageManager.PERMISSION_GRANTED) {
            //Name of Method for Calling Message
            MyTelephonyManager()
        } else {
            //TODO
            ActivityCompat.requestPermissions(this,
                    arrayOf(Manifest.permission.READ_PHONE_STATE),
                    MY_PERMISSIONS_REQUEST)
        }

    }

    @SuppressLint("MissingPermission")
    private fun MyTelephonyManager() {
        val manager = getSystemService(Context.TELEPHONY_SERVICE) as TelephonyManager
        val phoneType = manager.phoneType
        when (phoneType) {
            TelephonyManager.PHONE_TYPE_CDMA -> strphoneType = "CDMA"
            TelephonyManager.PHONE_TYPE_GSM -> strphoneType = "GSM"
            TelephonyManager.PHONE_TYPE_NONE -> strphoneType = "NONE"
        }
        val isRoaming = manager.isNetworkRoaming

        val PhoneType = strphoneType
        val IMEINumber = manager.deviceId
        val subscriberID = manager.deviceId
        val SIMSerialNumber = manager.simSerialNumber
        val networkCountryISO = manager.networkCountryIso
        val SIMCountryISO = manager.simCountryIso
        val softwareVersion = manager.deviceSoftwareVersion
        val voiceMailNumber = manager.voiceMailNumber

        info = "Phone Details:\n"
        info += "\n Phone Netwok Type: " + PhoneType
        info += "\n IMEI Number: " + IMEINumber
        info += "\n SubscriberID: " + subscriberID
        info += "\n Sim Serial Number: " + SIMSerialNumber
        info += "\n Network Country ISO: " + networkCountryISO
        info += "\n SIM Country ISO: " + SIMCountryISO
        info += "\n Software Version: " + softwareVersion
        info += "\n Voice Mail Number: " + voiceMailNumber
        info += "\n In Roaming: " + isRoaming

        txtView.setText(info)
    }

    override fun onRequestPermissionsResult(requestCode: Int, permissions: Array<String>, grantResults: IntArray) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        when (requestCode) {
            MY_PERMISSIONS_REQUEST -> {
                if (grantResults.size >= 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    //Name of Method for Calling Message
                    MyTelephonyManager()
                } else {
                    Toast.makeText(this, "You dont have required permission to make the Action", Toast.LENGTH_SHORT).show()
                }
            }
        }
    }
}
