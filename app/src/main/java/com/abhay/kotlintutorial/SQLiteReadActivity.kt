package com.abhay.kotlintutorial


import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_sqlite_read.*
import android.widget.Toast


class SQLiteReadActivity : AppCompatActivity() {

     lateinit var usersDBHelper : DataBaseHelper
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sqlite_read)
        usersDBHelper = DataBaseHelper(this)
    }

    fun btnRead(v:View){

        val res = usersDBHelper.getAllData()
        val stringBuffer = StringBuffer()
        if (res != null && res!!.getCount() > 0) {
            while (res!!.moveToNext()) {
                stringBuffer.append("Id: " + res!!.getString(0) + "\n")
                stringBuffer.append("Name: " + res!!.getString(1) + "\n")
                stringBuffer.append("Surname: " + res!!.getString(2) + "\n")
                stringBuffer.append("Marks: " + res!!.getString(3) + "\n" + "\n")
            }
            txtResult.text = stringBuffer.toString()
            Toast.makeText(this, "Data Retrieved Successfully", Toast.LENGTH_SHORT).show()
        } else {
            Toast.makeText(this, "No Data to Retrieve", Toast.LENGTH_SHORT).show()
        }


    }
}
