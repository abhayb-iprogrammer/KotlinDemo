package com.abhay.kotlintutorial


import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_sqlite_insert.*

class SQLiteInsertActivity : AppCompatActivity() {


    lateinit var usersDBHelper : DataBaseHelper
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sqlite_insert)
        usersDBHelper = DataBaseHelper(this)
    }

    fun BtnInsert(v:View){
        val name = edtName.getText().toString()
        val surname = edtSurname.getText().toString()
        val marks = edtMarks.getText().toString()

        val result=usersDBHelper.insertData(name,surname,marks)
        if (result == true) {

            Toast.makeText(this, "Data Inserted Successfully", Toast.LENGTH_SHORT).show()
        } else {
            Toast.makeText(this, "Data Insertion Failed", Toast.LENGTH_SHORT).show()
        }


    }
}
