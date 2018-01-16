package com.abhay.kotlintutorial

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import android.widget.SeekBar
import kotlinx.android.synthetic.main.activity_seek_bar.*


class SeekBarActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_seek_bar)

        seekBar.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener {
            override fun onProgressChanged(seekBar: SeekBar, i: Int, b: Boolean) {
                Toast.makeText(applicationContext, "SeekBar Progress: " + i, Toast.LENGTH_SHORT).show()
            }

            override fun onStartTrackingTouch(seekBar: SeekBar) {
                Toast.makeText(applicationContext, "SeekBar Touch Started", Toast.LENGTH_SHORT).show()
            }

            override fun onStopTrackingTouch(seekBar: SeekBar) {
                Toast.makeText(applicationContext, "SeekBar Touch Stopped", Toast.LENGTH_SHORT).show()
            }
        })
    }
}
