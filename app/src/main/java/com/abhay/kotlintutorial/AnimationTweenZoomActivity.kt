package com.abhay.kotlintutorial

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.animation.AnimationUtils
import kotlinx.android.synthetic.main.activity_animation_tween_zoom.*

class AnimationTweenZoomActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_animation_tween_zoom)
    }

    fun zoomIn(v:View){
        val animation = AnimationUtils.loadAnimation(applicationContext,
                R.anim.zoom_in)
        imageView.startAnimation(animation)
    }
    fun zoomOut(v:View){
        val animation = AnimationUtils.loadAnimation(applicationContext,
                R.anim.zoom_out)
        imageView.startAnimation(animation)
    }
}
