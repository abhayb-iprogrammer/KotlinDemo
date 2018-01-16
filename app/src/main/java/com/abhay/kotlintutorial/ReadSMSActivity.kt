package com.abhay.kotlintutorial

import android.Manifest
import android.content.pm.PackageManager
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.app.ActivityCompat
import android.widget.ArrayAdapter
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_read_contacts.*
import android.content.ContentResolver
import android.net.Uri
import android.support.v4.content.ContextCompat
import android.view.View
import android.widget.ViewAnimator


class ReadSMSActivity : AppCompatActivity() {
    var smsList: ArrayList<String>? = null
    private val MY_PERMISSIONS_REQUEST_READ_SMS = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_read_sms)
        smsList = ArrayList()

    }


    fun click(v: View)
    {
        val permissionCheck = ContextCompat.checkSelfPermission(this, Manifest.permission.READ_SMS)

        if (permissionCheck == PackageManager.PERMISSION_GRANTED) {
            //Name of Method for Calling Message
            showSMS()
        } else {
            //TODO
            ActivityCompat.requestPermissions(this,
                    arrayOf(Manifest.permission.READ_SMS),
                    MY_PERMISSIONS_REQUEST_READ_SMS)
        }
    }

    override fun onRequestPermissionsResult(requestCode: Int, permissions: Array<String>, grantResults: IntArray) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        when (requestCode) {
            MY_PERMISSIONS_REQUEST_READ_SMS -> {
                if (grantResults.size >= 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    //Name of Method for Calling show SMS
                    showSMS();
                    val adapter = ArrayAdapter(
                            this, android.R.layout.simple_list_item_1, smsList)
                    listView.setAdapter(adapter)
                } else {
                    Toast.makeText(this, "You dont have required permission to make the Action", Toast.LENGTH_SHORT).show()
                }
            }
        }
    }

    private fun showSMS() {
        // Create Inbox box URI
        val inboxURI = Uri.parse("content://sms/inbox")

        // Get Content Resolver object, which will deal with Content Provider
        val cr = contentResolver

        // Fetch Inbox SMS Message from Built-in Content Provider
        val c = cr.query(inboxURI, null, null, null, null)
        while (c!!.moveToNext()) {
                val Number = c.getString(c.getColumnIndexOrThrow("address")).toString()
                val Body = c.getString(c.getColumnIndexOrThrow("body")).toString()
                smsList!!.add("Number: $Number\nBody: $Body")

        }
        c.close()


    }
}
