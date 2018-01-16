package com.abhay.kotlintutorial

import android.Manifest
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_phone_call.*
import android.Manifest.permission
import android.Manifest.permission.CALL_PHONE
import android.annotation.SuppressLint
import android.support.v4.app.ActivityCompat
import android.widget.Toast
import android.content.pm.PackageManager
import android.content.Intent
import android.net.Uri
import android.support.v4.content.ContextCompat
import android.view.View


class PhoneCallActivity : AppCompatActivity() {
    private val MY_PERMISSIONS_REQUEST_CALL = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_phone_call)
    }

    @SuppressLint("MissingPermission")
    fun btnClick(v: View) {
        val permissionCheck = ContextCompat.checkSelfPermission(this, Manifest.permission.SEND_SMS)

        if (permissionCheck == PackageManager.PERMISSION_GRANTED) {
            //Name of Method for Calling
           MyCall()
        } else {
            //TODO
            ActivityCompat.requestPermissions(this,
                    arrayOf(Manifest.permission.CALL_PHONE),
                    MY_PERMISSIONS_REQUEST_CALL)
        }
    }

    override fun onRequestPermissionsResult(requestCode: Int, permissions: Array<String>, grantResults: IntArray) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        when (requestCode) {
            MY_PERMISSIONS_REQUEST_CALL -> {
                if (grantResults.size >= 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    //Name of Method for Calling Message
                    MyCall()
                } else {
                    Toast.makeText(this, "You dont have required permission to make the Action", Toast.LENGTH_SHORT).show()
                }
            }
        }
    }

    @SuppressLint("MissingPermission")
    fun MyCall(){
        val i = Intent(Intent.ACTION_CALL)
        var sNum = Numtxt.text
        if (sNum.trim().isEmpty()) {
            i.data = Uri.parse("tel:+917022367637")
        } else {
            i.data = Uri.parse("tel:" + sNum)
        }
        startActivity(i)
    }

}
