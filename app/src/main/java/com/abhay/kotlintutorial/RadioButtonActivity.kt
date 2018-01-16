package com.abhay.kotlintutorial

import android.graphics.Color
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.graphics.Color.parseColor
import android.support.annotation.IdRes
import android.widget.RadioGroup
import kotlinx.android.synthetic.main.activity_radio_button.*


class RadioButtonActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_radio_button)


        radioGroup.setOnCheckedChangeListener(RadioGroup.OnCheckedChangeListener { group, checkedId ->
            when (checkedId) {

                R.id.radiobutton1_Id -> window.decorView.setBackgroundColor(parseColor("#FF0000"))
                R.id.radiobutton2_Id -> window.decorView.setBackgroundColor(parseColor("#FFFF00"))
            }
        })
    }
}
