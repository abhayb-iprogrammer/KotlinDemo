package com.abhay.kotlintutorial

import android.net.Uri
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_video_view.*

class VideoViewActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_video_view)

        videoView.setVideoURI(Uri.parse("http://www.androidbegin.com/tutorial/AndroidCommercial.3gp"));
        videoView.requestFocus();
        videoView.start();
    }
}
