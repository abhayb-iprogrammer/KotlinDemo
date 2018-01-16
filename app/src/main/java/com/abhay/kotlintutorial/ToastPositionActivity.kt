package com.abhay.kotlintutorial

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.Gravity
import android.view.View
import android.widget.Toast



class ToastPositionActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_toast_position)
    }

    fun btnClick(v: View) {
        val toast1 = Toast.makeText(this, "Toast:Gravity.TOP", Toast.LENGTH_SHORT)
        toast1.setGravity(Gravity.TOP, 0, 0)
        toast1.show()

        val toast2 = Toast.makeText(this, "Toast:Gravity.CENTER", Toast.LENGTH_SHORT)
        toast2.setGravity(Gravity.CENTER, 0, 0)
        toast2.show()

        val toast3 = Toast.makeText(this, "Toast:Gravity.BOTTOM", Toast.LENGTH_SHORT)
        toast3.setGravity(Gravity.BOTTOM, 0, 0)
        toast3.show()

        val toast4 = Toast.makeText(this, "Toast:Gravity.LEFT", Toast.LENGTH_SHORT)
        toast4.setGravity(Gravity.LEFT, 0, 0)
        toast4.show()

        val toast5 = Toast.makeText(this, "Toast:Gravity.RIGHT", Toast.LENGTH_SHORT)
        toast5.setGravity(Gravity.RIGHT, 0, 0)
        toast5.show()

        val toast6 = Toast.makeText(this, "Toast TOP LEFT", Toast.LENGTH_SHORT)
        toast6.setGravity(Gravity.TOP or Gravity.LEFT, 0, 0)
        toast6.show()

        val toast7 = Toast.makeText(this, "Toast BOTTOM RIGHT", Toast.LENGTH_SHORT)
        toast7.setGravity(Gravity.BOTTOM or Gravity.RIGHT, 0, 0)
        toast7.show()

    }
}
