package com.abhay.kotlintutorial

import android.Manifest
import android.content.pm.PackageManager
import android.database.Cursor
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_read_contacts.*
import android.provider.ContactsContract
import android.support.v4.app.ActivityCompat
import android.support.v4.content.ContextCompat
import android.widget.ArrayAdapter
import android.widget.Toast


class ReadContactsActivity : AppCompatActivity() {
    private val MY_PERMISSIONS_REQUEST_READ_CONTACT = 0
    var contacts: ArrayList<String>? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_read_contacts)
        contacts = ArrayList()
        val permissionCheck = ContextCompat.checkSelfPermission(this, Manifest.permission.READ_CONTACTS)

        if (permissionCheck == PackageManager.PERMISSION_GRANTED) {
            //Name of Method for Calling Message
            showContacts()
            val adapter = ArrayAdapter(
                    this, android.R.layout.simple_list_item_1, contacts)
            listView.setAdapter(adapter)
        } else {
            //TODO
            ActivityCompat.requestPermissions(this,
                    arrayOf(Manifest.permission.READ_CONTACTS),
                    MY_PERMISSIONS_REQUEST_READ_CONTACT)
        }

    }

    private fun showContacts() {
       val cursor = contentResolver.query(ContactsContract.CommonDataKinds.Phone.CONTENT_URI, null, null, null, ContactsContract.Contacts.DISPLAY_NAME + " ASC ")


        while (cursor.moveToNext()) {

            if (cursor!=null) {
                val contactName = cursor.getString(cursor.getColumnIndex(ContactsContract.CommonDataKinds.Phone.DISPLAY_NAME))
                val phNumber = cursor.getString(cursor.getColumnIndex(ContactsContract.CommonDataKinds.Phone.NUMBER))
                contacts!!.add("Name: $contactName\nPhoneNo: $phNumber")
            }
            //Toast.makeText(this,"Contacts: "+contacts,Toast.LENGTH_SHORT).show();
        }
        cursor.close()
    }
    private fun requestPermission() {
        ActivityCompat.requestPermissions(this, arrayOf(Manifest.permission.READ_CONTACTS), 1)
    }

    override fun onRequestPermissionsResult(requestCode: Int, permissions: Array<String>, grantResults: IntArray) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        when (requestCode) {
            MY_PERMISSIONS_REQUEST_READ_CONTACT -> {
                if (grantResults.size >= 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    //Name of Method for Calling show SMS
                    showContacts();
                    val adapter = ArrayAdapter(
                            this, android.R.layout.simple_list_item_1, contacts)
                    listView.setAdapter(adapter)
                } else {
                    Toast.makeText(this, "You dont have required permission to make the Action", Toast.LENGTH_SHORT).show()
                }
            }
        }
    }
}
