package com.abhay.kotlintutorial

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_internal_storage.*
import android.widget.Toast
import android.R.attr.name
import android.app.Activity
import android.content.Context
import android.content.Context.MODE_PRIVATE
import android.view.View
import java.io.BufferedReader
import java.io.IOException
import java.io.InputStreamReader
import kotlinx.android.synthetic.main.activity_internal_storage.*
import java.io.OutputStreamWriter

class InternalStorageActivity : AppCompatActivity() {
    var FileName = "myFile"
    var name: String? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_internal_storage)

    }


     fun btnRead(V:View) {
         if(fileList().contains("notes.txt")) {
             try {
                 val file = InputStreamReader(openFileInput("notes.txt"))
                 val br = BufferedReader(file)
                 var line = br.readLine()
                 val all = StringBuilder()
                 while (line != null) {
                     all.append(line + "\n")
                     line = br.readLine()
                 }
                 br.close()
                 file.close()
                 readtxt.setText(all)
             }
             catch (e:IOException) {
             }
         }


     }

     fun btnSave(v:View) {
         try {
        val file = OutputStreamWriter(openFileOutput("notes.txt", Activity.MODE_PRIVATE))

        file.write (edtName.text.toString())
        file.flush ()
        file.close ()
    } catch (e : IOException) {
    }
    Toast.makeText(this, "Data Saved", Toast.LENGTH_SHORT).show()


    }
}
