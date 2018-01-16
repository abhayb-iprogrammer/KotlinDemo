package com.abhay.kotlintutorial

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import android.widget.TimePicker
import kotlinx.android.synthetic.main.activity_time_picker.*



class TimePickerActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_time_picker)
        timePicker.setOnTimeChangedListener(TimePicker.OnTimeChangedListener { timePicker, i, i1 ->
            Toast.makeText(applicationContext, "Time is $i:$i1", Toast.LENGTH_SHORT).show() })
    }
}
