package com.abhay.kotlintutorial

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_sqlite_delete.*



class SQLiteDeleteActivity : AppCompatActivity() {
    lateinit var usersDBHelper : DataBaseHelper
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sqlite_delete)
        usersDBHelper = DataBaseHelper(this)

    }

     fun btnDelete(v: View) {
        val id = edtID.text.toString()
        val result = usersDBHelper.deleteData(id)
        Toast.makeText(this, "Rows Affected :"+result, Toast.LENGTH_SHORT).show()
    }
}


