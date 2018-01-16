package com.abhay.kotlintutorial

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.R.attr.data
import android.widget.ArrayAdapter
import kotlinx.android.synthetic.main.activity_grid_view.*


class GridViewActivity : AppCompatActivity() {
    var data = arrayOf("data1", "data2", "data3", "data4", "data5", "data6", "data7", "data8")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_grid_view)
        val adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, data)
        gridView.setAdapter(adapter)
    }
}
