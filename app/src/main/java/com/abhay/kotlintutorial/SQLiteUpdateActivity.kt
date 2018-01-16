package com.abhay.kotlintutorial

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_sqlite_update.*


class SQLiteUpdateActivity : AppCompatActivity() {
     lateinit var usersDBHelper : DataBaseHelper
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sqlite_update)
        usersDBHelper= DataBaseHelper(this)
    }

     fun btnUpdate(v:View) {
        val id = edtID.text.toString()
        val name = edtName.text.toString()
        val surname = edtSurname.text.toString()
        val marks = edtMarks.text.toString()
        val result = usersDBHelper.updateData(id, name, surname, marks)
        if (result == true) {
            Toast.makeText(this, "Data Updated Successfully", Toast.LENGTH_SHORT).show()
            val intent = Intent(this, SQLiteReadActivity::class.java)
            //intent.putExtra(INTENT_USER_ID, user.id)
            startActivity(intent)

        } else {
            Toast.makeText(this, "No Rows Affected", Toast.LENGTH_SHORT).show()
        }

    }
}
