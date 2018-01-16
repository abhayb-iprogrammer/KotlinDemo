package com.abhay.kotlintutorial

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_date_picker.*
import android.widget.Toast

import android.widget.DatePicker
import java.util.*


class DatePickerActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_date_picker)

        val calendar = Calendar.getInstance()
        datePicker.init(calendar.get(Calendar.YEAR),
                calendar.get(Calendar.MONTH),
                calendar.get(Calendar.DAY_OF_MONTH))
        { datePicker, i, i1, i2 ->
            Toast.makeText(applicationContext, datePicker.dayOfMonth.toString() + "-" + datePicker.month + "-" + datePicker.year, Toast.LENGTH_SHORT).show() }

    }
}
