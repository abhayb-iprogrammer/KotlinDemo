package com.abhay.kotlintutorial

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_progress_bar.*


class ProgressBarActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_progress_bar)
    }

    fun onBtnClick(v: View) {
        val thread = object : Thread() {
            override fun run() {
                super.run()
                var i = 0
                while (i <= 100) {
                    try {
                        //Delay of one second by sleep(1000)
                        Thread.sleep(1000)
                    } catch (e: InterruptedException) {
                        e.printStackTrace()
                    }

                    //Updating ProgressBar
                    progressbar.setProgress(i)
                    i = i + 10
                }
            }
        }

        thread.start()

    }

}
