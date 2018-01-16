package com.abhay.kotlintutorial

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_rating_bar.*

class RatingBarActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_rating_bar)
    }

    fun onBtnClick(v: View) {
        val ratingvalue = ratingbar.getRating()
        Toast.makeText(applicationContext, "Rating is: " + ratingvalue, Toast.LENGTH_SHORT).show()

    }
}
