package com.abhay.kotlintutorial

import android.Manifest
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.telephony.SmsManager
import android.view.View
import android.widget.Toast
import android.text.TextUtils
import kotlinx.android.synthetic.main.activity_send_sms.*
import android.Manifest.permission
import android.Manifest.permission.SEND_SMS
import android.support.v4.app.ActivityCompat
import android.content.pm.PackageManager
import android.support.v4.content.ContextCompat




class SendSMSActivity : AppCompatActivity() {
    private val MY_PERMISSIONS_REQUEST_SEND_SMS = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_send_sms)
    }

    fun sendSms(v: View) {
        val permissionCheck = ContextCompat.checkSelfPermission(this, Manifest.permission.SEND_SMS)

        if (permissionCheck == PackageManager.PERMISSION_GRANTED) {
            //Name of Method for Calling Message
            MyMessage()
        } else {
            //TODO
            ActivityCompat.requestPermissions(this,
                    arrayOf(Manifest.permission.SEND_SMS),
                    MY_PERMISSIONS_REQUEST_SEND_SMS)
        }

    }

    override fun onRequestPermissionsResult(requestCode: Int, permissions: Array<String>, grantResults: IntArray) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        when (requestCode) {
            MY_PERMISSIONS_REQUEST_SEND_SMS -> {
                if (grantResults.size >= 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    //Name of Method for Calling Message
                    MyMessage()
                } else {
                    Toast.makeText(this, "You dont have required permission to make the Action", Toast.LENGTH_SHORT).show()
                }
            }
        }
    }

    fun MyMessage() {
        val myNumber = TxtPhoneNo.getText().toString().trim()
        val myMsg = TxtMsg.getText().toString().trim()
        //Begin Check for PhoneNumber
        if (myNumber == null || myNumber == "" || myMsg == null || myMsg == "") {
            Toast.makeText(this, "Field Cant be Empty", Toast.LENGTH_SHORT).show()
        } else {
            if (TextUtils.isDigitsOnly(myNumber)) {
                val smsManager = SmsManager.getDefault()
                smsManager.sendTextMessage(myNumber, null, myMsg, null, null)
                Toast.makeText(this, "Message Sent", Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(this, "Please Enter Integer Only", Toast.LENGTH_SHORT).show()
            }

        }
        //End Check for PhoneNumber
    }

}


