package com.abhay.kotlintutorial

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import kotlinx.android.synthetic.main.activity_spinner.*


class SpinnerActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_spinner)
        val countries = arrayOf("Afghanistan", "Bangladesh", "Belize", "France", "India", "Australia", "America", "Britain", "Ireland")
        val adapter = ArrayAdapter(this, android.R.layout.simple_spinner_dropdown_item, countries)
        spinner.setAdapter(adapter)
    }
}
