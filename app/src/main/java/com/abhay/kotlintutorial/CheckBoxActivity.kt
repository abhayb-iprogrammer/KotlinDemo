package com.abhay.kotlintutorial

import android.graphics.Color
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.graphics.Color.parseColor
import android.view.View
import kotlinx.android.synthetic.main.activity_check_box.*

class CheckBoxActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_check_box)
    }

    fun ClickMe(v: View) {
        if (checkBox1.isChecked() === true && checkBox2.isChecked() === true && checkBox3.isChecked() === true) {
            window.decorView.setBackgroundColor(parseColor("#FFFFFF"))
        } else if (checkBox1.isChecked() === true && checkBox2.isChecked() === true) {
            window.decorView.setBackgroundColor(parseColor("#FFFF00"))
        } else if (checkBox1.isChecked() === true && checkBox3.isChecked() === true) {
            window.decorView.setBackgroundColor(parseColor("#FF00FF"))
        } else if (checkBox2.isChecked() === true && checkBox3.isChecked() === true) {
            window.decorView.setBackgroundColor(parseColor("#00FFFF"))
        } else if (checkBox1.isChecked() === true) {
            window.decorView.setBackgroundColor(parseColor("#FF0000"))
        } else if (checkBox2.isChecked() === true) {
            window.decorView.setBackgroundColor(parseColor("#00FF00"))
        } else if (checkBox3.isChecked() === true) {
            window.decorView.setBackgroundColor(parseColor("#0000FF"))
        } else {
            window.decorView.setBackgroundColor(parseColor("#000000"))
        }
    }
}
