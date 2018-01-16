package com.abhay.kotlintutorial

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast

import android.view.View
import kotlinx.android.synthetic.main.activity_switch.*


class SwitchActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_switch)
    }

    fun onSwitchClick(v: View) {
        if (Switch.isChecked())
            Toast.makeText(this, "Toggle ON", Toast.LENGTH_SHORT).show()
        else
            Toast.makeText(this, "Toggle OFF", Toast.LENGTH_SHORT).show()

    }
}
