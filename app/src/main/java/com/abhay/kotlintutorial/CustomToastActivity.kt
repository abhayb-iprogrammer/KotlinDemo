package com.abhay.kotlintutorial

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.ViewGroup
import android.view.LayoutInflater
import kotlinx.android.synthetic.main.activity_custom_toast.*
import kotlinx.android.synthetic.main.activity_custom_toast_xml1.*
import android.view.Gravity
import android.widget.Toast


class CustomToastActivity : AppCompatActivity() {
    var viewLayout: View? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_custom_toast)
        val layoutInflater = layoutInflater
        viewLayout = layoutInflater.inflate(R.layout.activity_custom_toast_xml1, custom_layout)
    }

    fun btnClick(v: View) {
        val toast1 = Toast.makeText(this, "Toast:Gravity.TOP", Toast.LENGTH_SHORT)
        toast1.setGravity(Gravity.CENTER, 0, 0)
        toast1.view = viewLayout
        toast1.show()

    }
}
