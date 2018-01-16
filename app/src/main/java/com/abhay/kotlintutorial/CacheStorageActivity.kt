package com.abhay.kotlintutorial

import android.Manifest
import android.content.pm.PackageManager
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.os.Environment
import android.support.v4.app.ActivityCompat
import android.support.v4.content.ContextCompat
import android.view.View
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_external_storage_public_directory.*
import java.io.*

class CacheStorageActivity : AppCompatActivity() {
    private val PERMISION_WRITE_STORAGE = 1
    var FileName = "myFile_cache.txt"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cache_storage)
    }


    fun btnSave(v: View) {
        val permissionCheck = ContextCompat.checkSelfPermission(this, Manifest.permission.WRITE_EXTERNAL_STORAGE)

        if (permissionCheck == PackageManager.PERMISSION_GRANTED) {
            //Name of Method for Calling Message
            saveFile()
        } else {
            ActivityCompat.requestPermissions(this,
                    arrayOf(Manifest.permission.WRITE_EXTERNAL_STORAGE),
                    PERMISION_WRITE_STORAGE)
        }

    }

    override fun onRequestPermissionsResult(requestCode: Int, permissions: Array<String>, grantResults: IntArray) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        when (requestCode) {
            PERMISION_WRITE_STORAGE -> {
                if (grantResults.size >= 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    //Name of Method for storage
                    saveFile()
                } else {
                    Toast.makeText(this, "You dont have required permission to make the Action", Toast.LENGTH_SHORT).show()
                }
            }
        }
    }


    fun saveFile(){
        try {
            val f = File(cacheDir, FileName)

            f.createNewFile();
            //write the bytes in file
            val fos: FileOutputStream = FileOutputStream(f)
            fos.write(edtName.text.toString().toByteArray());
            fos.flush();
            fos.close();

            Toast.makeText(this, "Data Saved", Toast.LENGTH_SHORT).show()

            //or other method to save file

//            File(Environment.getExternalStorageDirectory(),FileName).printWriter().use {
//                it.println(e)
//            }

        } catch (e: java.io.IOException) {
            e.printStackTrace()
        }
    }

    fun btnRead(V: View) {

        try {

            val f = File(cacheDir, FileName)

            val fin = FileInputStream(f)
            val inputStream = InputStreamReader(fin)
            val bufferedReader = BufferedReader(inputStream)
            val stringBuilder = StringBuilder()
            var line: String? = null

            val lineList = mutableListOf<String>()

            bufferedReader.useLines { lines ->
                lines.forEach {
                    lineList.add(it)
                    stringBuilder.append(it)
                } }
            lineList.forEach { println("test-->  " + it) }


            fin.close()
            inputStream.close()
            readtxt.setText(" Name: " + stringBuilder.toString())
            Toast.makeText(this, "Data Retrieved :" + stringBuilder.toString(), Toast.LENGTH_SHORT).show()
        }
        catch (e: IOException) {
        }

    }

}
